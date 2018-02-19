package com.example.joker.sistofoodtest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class HorizontalStoryActivity extends AppCompatActivity {

    private ImageView imageView;
    private int position = 0;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_story);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        imageView = findViewById(R.id.storyImageView);
        handler = new Handler();

        setImage(position);
        Log.d("In StoryActivity",""+position);

        startHandler(position);
    }

    private void startHandler(final int pos) {
        this.position = pos;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                setImage(position);

                if(position < 5){
                    position++;
                    startHandler(position);
                }else{
                    finish();
                }
            }
        },2000);

    }

    private void setImage(int position) {

        switch (position) {
            case 0:
                Glide.with(this).load(R.drawable.eular).into(imageView);

                break;

            case 1:
                Glide.with(this).load(R.drawable.atom).into(imageView);
                break;

            case 2:
                Glide.with(this).load(R.drawable.hawk).into(imageView);
                break;

            case 3:
                Glide.with(this).load(R.drawable.saturn).into(imageView);
                break;

            case 4:
                Glide.with(this).load(R.drawable.food).into(imageView);
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        handler.removeCallbacksAndMessages(null);
        finish();

    }
}
