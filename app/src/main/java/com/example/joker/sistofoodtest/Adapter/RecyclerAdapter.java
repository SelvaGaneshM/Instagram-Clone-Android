package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.ClickListener;
import com.example.joker.sistofoodtest.FeedDetailActivity;
import com.example.joker.sistofoodtest.Models.FeedModels;
import com.example.joker.sistofoodtest.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private Context context;
    private ArrayList<FeedModels> feedModels = new ArrayList<>();
    private FragmentActivity fragmentActivity;
    private ClickListener clickListener;

    public RecyclerAdapter(Context context, FragmentActivity fragmentActivity , ArrayList<FeedModels> feedModels) {
        this.context = context;
        this.feedModels = feedModels;
        this.fragmentActivity = fragmentActivity;
        clickListener = (ClickListener) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_feed,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bindData(position);

    }

    @Override
    public int getItemCount() {
        return feedModels == null ? 0 : feedModels.size();
    }

    public void swapValues(ArrayList<FeedModels> feeds) {

        if(feeds != null && feeds != feedModels){
            feedModels = feeds;
        }

        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,smallTitle,shareTextView,likeTextView,dateTextView;
        private CardView cardView;
        private ImageView imageView,playImageView;



        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardViewContainer);
            title = (TextView) itemView.findViewById(R.id.titileTextView);
            smallTitle = (TextView) itemView.findViewById(R.id.typeTextView);
            shareTextView = (TextView) itemView.findViewById(R.id.shareTextView);
            likeTextView = (TextView) itemView.findViewById(R.id.likeTextView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            playImageView = (ImageView) itemView.findViewById(R.id.playImage);

            Typeface coustom_font_bold = Typeface.createFromAsset(context.getAssets(), "fonts/JosefinSansSemiBold.ttf");
            title.setTypeface(coustom_font_bold);

        }

        public void bindData(final int position) {

            title.setText(feedModels.get(position).getTitile());
            smallTitle.setText(feedModels.get(position).getSmallTitile());
            //likeTextView.setText(feedModels.get(position).getLike());
            dateTextView.setText(feedModels.get(position).getDate());


            if(position == 3 || position == 0){
                playImageView.setVisibility(View.VISIBLE);
            }

            switch (position){
                case 0 :
                    imageView.setImageResource(R.drawable.atom);
                    break;
                case 1 :
                    imageView.setImageResource(R.drawable.saturn);
                    break;

                case 2:
                    imageView.setImageResource(R.drawable.hawk);
                    break;

                case 3:
                    imageView.setImageResource(R.drawable.food);
                    break;

                case 4:
                    imageView.setImageResource(R.drawable.goals);
                    break;

                case 5:
                    imageView.setImageResource(R.drawable.eular);
                    break;
            }



            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.DrawerClickListerner(position);
                }
            });

        }
    }
}
