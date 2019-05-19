package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.R;

import org.jetbrains.annotations.NotNull;

/**
 * Created by joker on 19/2/18.
 */

public class UserPostAdapter extends RecyclerView.Adapter<UserPostAdapter.ViewHolder> {

    private Context context;

    public UserPostAdapter(Context context) {
        this.context = context;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_post_listitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.userPostImageView);
        }

        public void bindData(int position) {

            switch (position){
                case 0:
                    Glide.with(context).load(R.drawable.saturn).into(imageView);
                    break;
                case 1:
                    Glide.with(context).load(R.drawable.man).into(imageView);
                    break;
                case 2:
                    Glide.with(context).load(R.drawable.manage).into(imageView);
                    break;
                case 3:
                    Glide.with(context).load(R.drawable.hawk).into(imageView);
                    break;
                case 4:
                    Glide.with(context).load(R.drawable.goals).into(imageView);
                    break;
                case 5:
                    Glide.with(context).load(R.drawable.girl).into(imageView);
                    break;
                case 6:
                    Glide.with(context).load(R.drawable.atom).into(imageView);
                    break;
                case 7:
                    Glide.with(context).load(R.drawable.eular).into(imageView);
                    break;
            }

        }
    }
}
