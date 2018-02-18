package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.R;

/**
 * Created by joker on 18/2/18.
 */

public class HorizontalScrollAdapter extends RecyclerView.Adapter<HorizontalScrollAdapter.ViewHolder> {


    private Context context;

    public HorizontalScrollAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_stories,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.storiesImageVeiw);
        }

        public void bindData(int position) {

            switch (position) {
                case 0:
                    Glide.with(context).load(R.drawable.eular).into(imageView);
                    break;

                case 1:
                    Glide.with(context).load(R.drawable.man).into(imageView);
                    break;

                case 2:
                    Glide.with(context).load(R.drawable.hawk).into(imageView);
                    break;

                case 3:
                    Glide.with(context).load(R.drawable.girl).into(imageView);
                    break;

                case 4:
                    Glide.with(context).load(R.drawable.food).into(imageView);
                    break;



            }

        }
    }
}
