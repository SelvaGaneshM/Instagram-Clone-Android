package com.example.joker.sistofoodtest.Models;

/**
 * Created by joker on 16/2/18.
 */

public class StatusModel {

    private String name,time;

    public StatusModel(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
