package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.Models.FollowingModel;
import com.example.joker.sistofoodtest.R;

import java.util.ArrayList;

/**
 * Created by joker on 16/2/18.
 */

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.ViewHolder> {

    private ArrayList<FollowingModel> followingModels = new ArrayList<>();
    private Context context;

    public FollowingAdapter(ArrayList<FollowingModel> followingModels, Context context) {
        this.followingModels = followingModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.following_listitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return followingModels == null ? 0 : followingModels.size();
    }

    public void swapAdapter(ArrayList<FollowingModel> status) {

        if(status != null && status != followingModels){
            followingModels = status;
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView,commentTextView, timeTextView;
        private ImageView profPic;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.followerTextView);
            commentTextView = (TextView) itemView.findViewById(R.id.commentTextView);
            timeTextView = (TextView) itemView.findViewById(R.id.commentTimeTextView);
            profPic = (ImageView) itemView.findViewById(R.id.following_imageView);

        }

        public void bindData(int position) {
            nameTextView.setText(followingModels.get(position).getName());
            commentTextView.setText(followingModels.get(position).getComment());
            timeTextView.setText(followingModels.get(position).getTime());

            switch (position) {
                case 0:
                    Glide.with(context).load(R.drawable.man).into(profPic);
                    break;

                case 1:
                    Glide.with(context).load(R.drawable.eular).into(profPic);
                    break;

                case 2:
                    Glide.with(context).load(R.drawable.man).into(profPic);
                    break;

                case 3:
                    Glide.with(context).load(R.drawable.goals).into(profPic);
                    break;

                case 4:
                    Glide.with(context).load(R.drawable.food).into(profPic);
                    break;

                case 5:
                    Glide.with(context).load(R.drawable.man).into(profPic);
                    break;

                case 6:
                    Glide.with(context).load(R.drawable.eular).into(profPic);
                    break;

                case 7:
                    Glide.with(context).load(R.drawable.man).into(profPic);
                    break;

                case 8:
                    Glide.with(context).load(R.drawable.man).into(profPic);
            }

        }
    }


}
