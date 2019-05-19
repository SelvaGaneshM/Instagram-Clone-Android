package com.example.joker.sistofoodtest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.joker.sistofoodtest.Models.Post;
import com.example.joker.sistofoodtest.Models.User;
import com.example.joker.sistofoodtest.helper.FirebaseHelper;
import com.example.joker.sistofoodtest.helper.SharedPref;
import com.fxn.pix.Pix;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleActivity extends AppCompatActivity {

    private static final int RC_PIX = 101;

    private CircleImageView userImage;
    private ImageView selectedImage;
    private EditText articleET;
    private String imagePath = "";
    private String caption = "";
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        userImage = findViewById(R.id.userProfilePic);
        articleET = findViewById(R.id.articleEditText);
        selectedImage = findViewById(R.id.selecteImage);
        linearLayout = findViewById(R.id.progressContainer);

        Glide.with(this)
                .load(SharedPref.getInstance(getApplicationContext()).getUser().getUserImage())
                .into(userImage);

    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void post(View view) {
        //Todo upload image
        caption = articleET.getText().toString().trim();
        if (caption.length() < 10) {
            showToast("Caption to small");
            return;
        }

        if (imagePath.length() == 0) {
            showToast("Please select picture");
            return;
        }

        uploadImageToStorage(imagePath);

    }

    //TODO compelte this
    private void uploadImageToStorage(String imagePath) {
        linearLayout.setVisibility(View.VISIBLE);
        final UploadTask uploadTask = FirebaseHelper.setFile(imagePath);
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //upload completed
                FirebaseHelper.getImageRef().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        updateDatabase(uri.toString());
                    }
                });

                linearLayout.setVisibility(View.GONE);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("Upload error. Try again");
                linearLayout.setVisibility(View.GONE);
            }
        });
    }

    private void updateDatabase(String imageUrl) {

        long unixTime = System.currentTimeMillis() / 1000L;
        User user = SharedPref.getInstance(getApplicationContext()).getUser();
        Post post = new Post(caption, unixTime, imageUrl, user);
        FirebaseHelper.getPostRef().child(String.valueOf(unixTime)).setValue(post);
        finish();

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void openGallery(View view) {
        Pix.start(ArticleActivity.this, RC_PIX, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && requestCode == RC_PIX) {
            ArrayList<String> images = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            imagePath = images.get(0);
            Glide.with(ArticleActivity.this).load(new File(imagePath)).into(selectedImage);
        }
    }

    @Override
    public void onBackPressed() {
        if(linearLayout.getVisibility() == View.VISIBLE){
            showToast("Please wait");
        }else {
            super.onBackPressed();
        }
    }
}
