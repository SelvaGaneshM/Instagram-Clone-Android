package com.example.joker.sistofoodtest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.sistofoodtest.Adapter.StatusAdapter;
import com.example.joker.sistofoodtest.DataSet.FeedData;
import com.example.joker.sistofoodtest.Models.FeedModels;
import com.example.joker.sistofoodtest.Models.StatusModel;
import com.example.joker.sistofoodtest.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class Status extends Fragment {

    private ArrayList<StatusModel> status = new ArrayList<>();
    private RecyclerView recyclerView;

    public Status() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status,container,false);

        init();
        recyclerView = (RecyclerView) view.findViewById(R.id.statusRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        StatusAdapter adapter = new StatusAdapter(status,getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void init() {

        String jsonData = FeedData.getJsonData(getContext(),3);

        try {

            JSONObject jsonFeeds = new JSONObject(jsonData);
            JSONArray jsonArray =  jsonFeeds.getJSONArray("details");
            for(int i=0 ; i<jsonArray.length(); i++){

                JSONObject statu = jsonArray.getJSONObject(i);

                String name = statu.getString("name");
                String time = statu.getString("time");

                status.add(new StatusModel(name,time));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }
}
