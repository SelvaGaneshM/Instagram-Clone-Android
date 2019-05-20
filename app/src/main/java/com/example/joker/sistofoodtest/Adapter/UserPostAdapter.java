package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joker on 19/2/18.
 */

public class UserPostAdapter extends RecyclerView.Adapter<UserPostAdapter.ViewHolder> {

    private Context context;
    private List<String> posts = new ArrayList<>();

    public UserPostAdapter(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_post_listitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    public void add(String imageUrl) {
        int posititon = posts.size() - 1;
        posts.add(imageUrl);
        notifyItemInserted(posititon);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.userPostImageView);
        }

        public void bindData(int position) {

            Glide.with(context).load(posts.get(position)).into(imageView);


        }
    }
}
