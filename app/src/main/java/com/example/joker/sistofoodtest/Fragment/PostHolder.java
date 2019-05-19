package com.example.joker.sistofoodtest.Fragment;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.sistofoodtest.Adapter.RecyclerAdapter;
import com.example.joker.sistofoodtest.R;

class PostHolder extends RecyclerView.ViewHolder {

    ImageView logoView, postImageView;
    TextView userName, postTime, userCaption;


    public PostHolder(@NonNull View itemView) {
        super(itemView);

        logoView = itemView.findViewById(R.id.user_feed_imageview);
        postImageView = itemView.findViewById(R.id.imageView);
        userName = itemView.findViewById(R.id.userNameTextView);
        postTime = itemView.findViewById(R.id.dateTextView);
        userCaption = itemView.findViewById(R.id.titileTextView);

    }

}
