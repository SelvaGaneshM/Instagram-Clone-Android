package com.example.joker.sistofoodtest.Models;

/**
 * Created by joker on 15/2/18.
 */

public class FeedModels {

    private String user;
    private String date;
    private String titile;
    private String smallTitile;
    private String imageUrl;
    private String like;

    public FeedModels(String user, String date, String titile, String smallTitile, String imageUrl,String like) {
        this.user = user;
        this.date = date;
        this.titile = titile;
        this.smallTitile = smallTitile;
        this.imageUrl = imageUrl;
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public String getTitile() {
        return titile;
    }

    public String getSmallTitile() {
        return smallTitile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLike() {
        return like;
    }
}
