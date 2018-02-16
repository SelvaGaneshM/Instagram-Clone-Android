package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.Models.StatusModel;
import com.example.joker.sistofoodtest.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by joker on 16/2/18.
 */

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private ArrayList<StatusModel> statusModels = new ArrayList<>();
    private Context context;

    public StatusAdapter(ArrayList<StatusModel> statusModels, Context context) {
        this.statusModels = statusModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_listitem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return statusModels == null ? 0 : statusModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, timeTextView;
        private ImageView profPic;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.statusName);
            timeTextView = (TextView) itemView.findViewById(R.id.statusTime);
            profPic = (ImageView) itemView.findViewById(R.id.statusImage);

        }

        public void bindData(int position) {
            nameTextView.setText(statusModels.get(position).getName());
            timeTextView.setText(statusModels.get(position).getTime());

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
            }

        }
    }


}
