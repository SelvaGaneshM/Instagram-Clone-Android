package com.example.joker.sistofoodtest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.sistofoodtest.Adapter.UserPostAdapter;
import com.example.joker.sistofoodtest.Models.FollowingModel;
import com.example.joker.sistofoodtest.R;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class User extends Fragment {

    private ArrayList<FollowingModel> status = new ArrayList<>();
    private RecyclerView userRecyclerView;


    public User() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragemnt_user_layout,container,false);

        userRecyclerView = view.findViewById(R.id.userRecyclerView);
        userRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        UserPostAdapter adapter = new UserPostAdapter(getContext());
        userRecyclerView.setAdapter(adapter);

        return view;
    }
}
