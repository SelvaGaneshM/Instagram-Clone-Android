package com.example.joker.sistofoodtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.joker.sistofoodtest.DataSet.FeedData;

import java.io.IOException;
import java.io.InputStream;

public class FeedDetailActivity extends AppCompatActivity {

    private String title = "Saturn's Moon Titan Is Covered in Electrified Sand";
    private String description = "So what's happening here? Basically, as the wind on the moon kicks up, the granules of sand collide with each other and become frictionally charged, like a staticky sweater you just pulled out of the dryer. The same phenomenon happens on Earth, by the way, but the conditions on Titan make the electrical forces develop much more strongly. In an experiment at Georgia Tech, researchers took grains of naphthalene and biphenyl (compounds believed to exist on Titan\\'s surface) and put them in a pressure chamber recreating the moon's nitrogen-rich atmosphere. After about 20 minutes of shaking, the sand began to stick together, and about 2–5 percent of it was so electrically charged it wouldn't fall out of the tumbler. According to professor Josef Dudek, who co-led the study, \"If you grabbed piles of grains and built a sand castle on Titan, it would perhaps stay together for weeks due to their electrostatic properties.";

    private TextView titleTextView,descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail);

        titleTextView = (TextView) findViewById(R.id.detailTitile);
        descriptionTextView = (TextView) findViewById(R.id.detailDescription);

        titleTextView.setText(title);
        descriptionTextView.setText(description);


        Intent intent = getIntent();
        int position = intent.getIntExtra("feedno",0);
        if(position == 0){
            Log.d("Feed No","it is null");
        }else{
            Log.d("Feed No",""+position);

        }

    }

}
