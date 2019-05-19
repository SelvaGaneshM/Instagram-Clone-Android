package com.example.joker.sistofoodtest.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private String userId = "";
    private String userName = "";
    private String userEmail = "";
    private String userImage = "";
    private List<String> userPosts = new ArrayList<>();

    public User(){}

    public User(String userId, String userName, String userEmail, String userImage, List<String> userPosts) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImage = userImage;
        this.userPosts = userPosts;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserImage() {
        return userImage;
    }

    public List<String> getUserPosts() {
        return userPosts;
    }
}
