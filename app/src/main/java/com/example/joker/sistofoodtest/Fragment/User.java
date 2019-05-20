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

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.Adapter.UserPostAdapter;
import com.example.joker.sistofoodtest.Models.FollowingModel;
import com.example.joker.sistofoodtest.R;
import com.example.joker.sistofoodtest.helper.SharedPref;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by joker on 15/2/18.
 */

public class User extends Fragment {

    private ArrayList<FollowingModel> status = new ArrayList<>();
    private RecyclerView userRecyclerView;
    private CircleImageView circleImageView;


    public User() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragemnt_user_layout,container,false);

        circleImageView = view.findViewById(R.id.profile_image);
        Glide.with(getContext())
                .load(new File(SharedPref
                        .getInstance(getContext())
                        .getUser()
                        .getUserImage()))
                .into(circleImageView);

        userRecyclerView = view.findViewById(R.id.userRecyclerView);
        userRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        UserPostAdapter adapter = new UserPostAdapter(getContext());
        userRecyclerView.setAdapter(adapter);

        return view;
    }
}
