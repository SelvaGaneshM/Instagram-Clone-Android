package com.example.joker.sistofoodtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.sistofoodtest.Adapter.ViewpagerAdapter;

public class MainActivity extends AppCompatActivity implements ClickListener {


    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private TextView notificationBar;
    private ImageView addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        notificationBar = (TextView) findViewById(R.id.notificationBar);
        addBtn = (ImageView) findViewById(R.id.addBtn);

        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        //method to set BottomNavigation and disable ViewPager swipe action
        init();



    }

    //method to set BottomNavigation and disable ViewPager swipe action
    private void init() {
        //bottom navigation for viewpager swipe
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                viewPager.setCurrentItem(0);
                                notificationBar.setText("Feeds");
                                break;

                            case R.id.status:
                                viewPager.setCurrentItem(1);
                                notificationBar.setText("Status");
                                break;

                            case R.id.user:
                                viewPager.setCurrentItem(2);
                                notificationBar.setText("Me");
                                break;
                        }
                        return true;
                    }
                });


        //override viewpager to disabel its swipe.
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    @Override
    public void DrawerClickListerner(int position) {
        Intent intent = new Intent(this,FeedDetailActivity.class);
        intent.putExtra("feedno",position);
        Log.d("Feed No Mainactivity ",""+position);
        startActivity(intent);
    }

    public void startCamera(View view) {

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);

    }
}
