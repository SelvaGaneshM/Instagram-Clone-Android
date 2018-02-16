package com.example.joker.sistofoodtest.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.sistofoodtest.Models.StatusModel;
import com.example.joker.sistofoodtest.R;

import java.util.ArrayList;

/**
 * Created by joker on 15/2/18.
 */

public class User extends Fragment {

    private ArrayList<StatusModel> status = new ArrayList<>();

    public User() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,container,false);

        Log.d("onCreateView","user get called");

        return view;
    }
}
