package com.example.joker.sistofoodtest.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.Adapter.HorizontalScrollAdapter;
import com.example.joker.sistofoodtest.Adapter.RecyclerAdapter;
import com.example.joker.sistofoodtest.DataSet.FeedData;
import com.example.joker.sistofoodtest.MainActivity;
import com.example.joker.sistofoodtest.Models.FeedModels;
import com.example.joker.sistofoodtest.Models.Post;
import com.example.joker.sistofoodtest.R;
import com.example.joker.sistofoodtest.helper.FirebaseHelper;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.google.firebase.database.Query;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class Home extends Fragment {

    private RecyclerView recyclerView;
    private TextView loadingTV;

    public Home() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        loadingTV = view.findViewById(R.id.loadingTV);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Query query = FirebaseHelper.getPostRef();
        FirebaseRecyclerOptions<Post> options = new FirebaseRecyclerOptions.Builder<Post>().setQuery(query, Post.class).setLifecycleOwner(this).build();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Post, PostHolder>(options) {

            @NonNull
            @Override
            public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_feed, viewGroup, false);
                return new PostHolder(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull PostHolder holder, int position, @NonNull Post model) {

                if(loadingTV.getVisibility() == View.VISIBLE){
                    loadingTV.setVisibility(View.GONE);
                }


                Glide.with(getContext()).load(model.getUser().getUserImage()).thumbnail(0.1f).into(holder.logoView);

                String userName = model.getUser().getUserName();
                userName = userName.replaceAll(" ", "_").toLowerCase();

                holder.userName.setText(userName);

                holder.postTime.setText(FirebaseHelper.getTime(model.getUploadTimestamp()));

                Glide.with(getContext()).load(model.getImageUrl()).thumbnail(0.1f).into(holder.postImageView);

                holder.userCaption.setText(model.getCaption());
                Typeface coustom_font_bold = Typeface.createFromAsset(getContext().getAssets(), "fonts/JosefinSansSemiBold.ttf");
                holder.userCaption.setTypeface(coustom_font_bold);

            }
        };

        recyclerView.setAdapter(adapter);

        return view;
    }

}
