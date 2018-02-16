package com.example.joker.sistofoodtest.Models;

/**
 * Created by joker on 16/2/18.
 */

public class DetailFeedModel {

    private String title,description,tag;

    public DetailFeedModel(String title, String description, String tag) {
        this.title = title;
        this.description = description;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }
}
