package com.example.joker.sistofoodtest.Fragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.sistofoodtest.Adapter.FollowingAdapter;
import com.example.joker.sistofoodtest.DataSet.FeedData;
import com.example.joker.sistofoodtest.Models.FollowingModel;
import com.example.joker.sistofoodtest.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class Status extends Fragment {

    private ArrayList<FollowingModel> status = new ArrayList<>();
    private RecyclerView recyclerView;
    private FollowingAdapter statusAdapter;

    public Status() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.follwingRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        statusAdapter = new FollowingAdapter(status,getContext());
        recyclerView.setAdapter(statusAdapter);

        new AsysncStatus().execute();

        return view;
    }

    @SuppressLint("StaticFieldLeak")
    public class AsysncStatus extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            init();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            statusAdapter.swapAdapter(status);

        }
    }

    private void init() {

        String jsonData = FeedData.getJsonData(getContext(),3);

        try {

            JSONObject jsonFeeds = new JSONObject(jsonData);
            JSONArray jsonArray =  jsonFeeds.getJSONArray("details");
            for(int i=0 ; i<jsonArray.length(); i++){

                JSONObject statu = jsonArray.getJSONObject(i);

                String name = statu.getString("name");
                String comment = statu.getString("tag");
                String time = statu.getString("time");

                status.add(new FollowingModel(name,comment,time));
            }

        }catch (Exception e){

            e.printStackTrace();

        }

    }
}
