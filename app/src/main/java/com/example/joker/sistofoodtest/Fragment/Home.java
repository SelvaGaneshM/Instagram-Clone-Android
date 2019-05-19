package com.example.joker.sistofoodtest.Fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
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

import com.example.joker.sistofoodtest.Adapter.HorizontalScrollAdapter;
import com.example.joker.sistofoodtest.Adapter.RecyclerAdapter;
import com.example.joker.sistofoodtest.DataSet.FeedData;
import com.example.joker.sistofoodtest.Models.FeedModels;
import com.example.joker.sistofoodtest.R;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class Home extends Fragment {

    private ArrayList<FeedModels> feeds = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView horizontalRecycler;

    public Home() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);



        //feed list
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        recyclerAdapter = new RecyclerAdapter(getContext(),getActivity(),feeds);
        recyclerView.setAdapter(recyclerAdapter);

        new AsyncFeed().execute();

        return view;
    }


    @SuppressLint("StaticFieldLeak")
    public class AsyncFeed extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            init();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            recyclerAdapter.swapValues(feeds);

        }
    }

    private void init() {

        String jsonData = FeedData.getJsonData(getContext(),1);

        try {

            JSONObject jsonFeeds = new JSONObject(jsonData);
            JSONArray jsonArray =  jsonFeeds.getJSONArray("feeds");
            for(int i=0 ; i<jsonArray.length(); i++){

                JSONObject feed = jsonArray.getJSONObject(i);

                String user = feed.getString("user");
                String date = feed.getString("date");
                String title = feed.getString("title");
                String smallTitle = feed.getString("tag");
                String imageUrl = feed.getString("imageUrl");
                String like = feed.getString("like");

                feeds.add(new FeedModels(user,date,title,smallTitle,imageUrl,like));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}
