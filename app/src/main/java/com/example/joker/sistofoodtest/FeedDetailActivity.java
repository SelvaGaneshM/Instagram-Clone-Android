package com.example.joker.sistofoodtest;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.sistofoodtest.Models.DetailFeedModel;
import com.example.joker.sistofoodtest.DataSet.FeedData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FeedDetailActivity extends AppCompatActivity {

    private ArrayList<DetailFeedModel> feeds = new ArrayList<>();
    private TextView titleTextView, descriptionTextView, tagTextView;
    private ImageView detailImageView;
    private int dataPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail);

        Intent intent = getIntent();
        dataPosition = intent.getIntExtra("feedno", 0);

        init();

        titleTextView = (TextView) findViewById(R.id.detailTitile);
        descriptionTextView = (TextView) findViewById(R.id.detailDescription);
        tagTextView = (TextView) findViewById(R.id.tagTextView);
        detailImageView = (ImageView) findViewById(R.id.detailImageView);

        Typeface coustom_font = Typeface.createFromAsset(this.getAssets(), "fonts/JosefinSansLight.ttf");
        Typeface coustom_font_bold = Typeface.createFromAsset(this.getAssets(), "fonts/JosefinSansSemiBold.ttf");

        titleTextView.setTypeface(coustom_font_bold);
        descriptionTextView.setTypeface(coustom_font_bold);


        titleTextView.setText(feeds.get(dataPosition).getTitle());
        descriptionTextView.setText(feeds.get(dataPosition).getDescription());
        tagTextView.setText(feeds.get(dataPosition).getTag());
        setImage();

    }

    private void setImage() {

        int position = dataPosition;

        switch (position){
            case 0 :
                detailImageView.setImageResource(R.drawable.atom);
                break;
            case 1 :
                detailImageView.setImageResource(R.drawable.saturn);
                break;

            case 2:
                detailImageView.setImageResource(R.drawable.hawk);
                break;

            case 3:
                detailImageView.setImageResource(R.drawable.food);
                break;

            case 4:
                detailImageView.setImageResource(R.drawable.goals);
                break;

            case 5:
                detailImageView.setImageResource(R.drawable.eular);
                break;
        }

    }

    private void init() {

        String jsonData = FeedData.getJsonData(this, 2);

        try {

            JSONObject jsonFeeds = new JSONObject(jsonData);
            JSONArray jsonArray = jsonFeeds.getJSONArray("detail");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonFeed = jsonArray.getJSONObject(i);
                String title = jsonFeed.getString("title");
                String description = jsonFeed.getString("description");
                String tag = jsonFeed.getString("tag");

                feeds.add(new DetailFeedModel(title, description, tag));
            }

            Log.d("Length ",""+feeds.size()+","+dataPosition);


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
