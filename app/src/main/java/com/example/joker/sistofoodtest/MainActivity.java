package com.example.joker.sistofoodtest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joker.sistofoodtest.Adapter.ViewpagerAdapter;

public class MainActivity extends AppCompatActivity implements ClickListener {


    private CustomViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private TextView notificationBar;
    private ImageView addBtn,editBtn;

    public static final int MY_CAMERA_REQUEST_CODE  = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);

        bottomNavigationView = findViewById(R.id.navigation);
        notificationBar = findViewById(R.id.notificationBar);
        addBtn = findViewById(R.id.addBtn);
        editBtn = findViewById(R.id.editBtn);

        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        //method to set BottomNavigation
        init();

    }

    //method to set BottomNavigation
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
    }

    @Override
    public void DrawerClickListerner(int position) {
        Intent intent = new Intent(this,FeedDetailActivity.class);
        intent.putExtra("feedno",position);
        Log.d("Feed No Mainactivity ",""+position);
        startActivity(intent);
    }

    @Override
    public void StoryClickListener(int a) {

        Intent intent = new Intent(this,HorizontalStoryActivity.class);
        intent.putExtra("position",a);
        startActivity(intent);

    }

    public void startCamera(View view) {

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},MY_CAMERA_REQUEST_CODE);

        }else{

            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode) {
            case MY_CAMERA_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast.makeText(this,"Starting Camera",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }


    }

    public void newArticle(View view) {

        startActivity(new Intent(MainActivity.this,ArticleActivity.class));

    }
}
