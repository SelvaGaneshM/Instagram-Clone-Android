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
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements ClickListener {


    private CustomViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    private TextView notificationBar;
    private ImageView addBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);

        bottomNavigationView = findViewById(R.id.navigation);
        notificationBar = findViewById(R.id.notificationBar);
        addBtn = findViewById(R.id.addBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        //method to set BottomNavigation
        init();

    }

    //method to set BottomNavigation
    private void init() {
        //bottom navigation for viewpager swipe
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
        Intent intent = new Intent(this, FeedDetailActivity.class);
        intent.putExtra("feedno", position);
        Log.d("Feed No Mainactivity ", "" + position);
        startActivity(intent);
    }


    //TODO remove this story part from the applicaton
    @Override
    public void StoryClickListener(int a) {

        Intent intent = new Intent(this, HorizontalStoryActivity.class);
        intent.putExtra("position", a);
        startActivity(intent);

    }

    public void logout(View view) {
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MainActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    public void newArticle(View view) {

        startActivity(new Intent(MainActivity.this, ArticleActivity.class));

    }
}
