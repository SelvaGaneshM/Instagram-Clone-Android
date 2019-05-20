package com.example.joker.sistofoodtest.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.joker.sistofoodtest.Models.Post;
import com.example.joker.sistofoodtest.R;
import com.example.joker.sistofoodtest.helper.FirebaseHelper;
import com.example.joker.sistofoodtest.helper.SharedPref;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by joker on 15/2/18.
 */

public class User extends Fragment {

    private ArrayList<String> posts = new ArrayList<>();
    private RecyclerView userRecyclerView;
    private CircleImageView circleImageView;


    public User() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragemnt_user_layout, container, false);

        final com.example.joker.sistofoodtest.Models.User user = SharedPref.getInstance(getContext()).getUser();

        circleImageView = view.findViewById(R.id.profile_image);
        Glide.with(getContext()).load(user.getUserImage()).into(circleImageView);

        userRecyclerView = view.findViewById(R.id.userRecyclerView);
        userRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        final UserPostAdapter adapter = new UserPostAdapter(getContext());
        userRecyclerView.setAdapter(adapter);

        FirebaseHelper.getPostRef().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Post post = dataSnapshot.getValue(Post.class);
                if (post.getUser().getUserId().equals(user.getUserId())) {
                    adapter.add(post.getImageUrl());
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//no use
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//no use
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//no use
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
//no use
            }
        });

        return view;
    }
}
