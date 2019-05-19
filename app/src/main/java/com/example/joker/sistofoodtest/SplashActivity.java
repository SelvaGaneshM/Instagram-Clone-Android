package com.example.joker.sistofoodtest;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.helper.FirebaseHelper;
import com.example.joker.sistofoodtest.helper.SharedPref;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 100;
    // Choose authentication providers
    List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseHelper.init(getApplicationContext());

        ImageView imageView = findViewById(R.id.logoImageView);
        Glide.with(this).load(R.drawable.instagram_log).into(imageView);

        FirebaseAuth auth = FirebaseHelper.getFirebaseAuth();
        if (auth.getCurrentUser() == null) {
            // Create and launch sign-in intent
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(), RC_SIGN_IN);

        } else {
            gotoMainActivity();
        }


    }

    private void gotoMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseHelper.saveUser(getApplicationContext());
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 1500);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                SharedPref.getInstance(getApplicationContext()).saveUser(user);
                gotoMainActivity();

            } else {
                // Sign in failed. If response is null the user canceled the
                Toast.makeText(SplashActivity.this, "Authentication Error", Toast.LENGTH_SHORT).show();
                Log.d("auth_error", response.getError().toString());

            }
        }

    }
}
