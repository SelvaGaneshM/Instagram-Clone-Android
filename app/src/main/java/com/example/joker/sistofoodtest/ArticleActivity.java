package com.example.joker.sistofoodtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
    }

    public void goBack(View view) {

        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}
