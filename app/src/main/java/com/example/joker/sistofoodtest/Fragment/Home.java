package com.example.joker.sistofoodtest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.sistofoodtest.Adapter.RecyclerAdapter;
import com.example.joker.sistofoodtest.DataSet.FeedData;
import com.example.joker.sistofoodtest.Models.FeedModels;
import com.example.joker.sistofoodtest.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class Home extends Fragment {

    private ArrayList<FeedModels> feeds = new ArrayList<>();
    private RecyclerView recyclerView;

    public Home() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        init();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext(),getActivity(),feeds);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }


    private void init() {

        String jsonData = FeedData.getJsonData(getContext());

        try {

            JSONObject jsonFeeds = new JSONObject(jsonData);
            JSONArray jsonArray =  jsonFeeds.getJSONArray("feeds");
            for(int i=0 ; i<jsonArray.length(); i++){

                JSONObject feed = jsonArray.getJSONObject(i);

                String date = feed.getString("date");
                String title = feed.getString("title");
                String smallTitle = feed.getString("tag");
                String imageUrl = feed.getString("imageUrl");
                String like = feed.getString("like");

                feeds.add(new FeedModels(date,title,smallTitle,imageUrl,like));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }

}
