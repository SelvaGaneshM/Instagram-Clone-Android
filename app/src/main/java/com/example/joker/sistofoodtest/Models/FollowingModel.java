package com.example.joker.sistofoodtest.Models;

/**
 * Created by joker on 16/2/18.
 */

public class FollowingModel {

    private String name,comment,time;

    public FollowingModel(String name, String comment, String time) {
        this.name = name;
        this.comment = comment;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getTime() {
        return time;
    }
}
