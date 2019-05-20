package com.example.joker.sistofoodtest.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.joker.sistofoodtest.Fragment.Home;
import com.example.joker.sistofoodtest.Fragment.Status;
import com.example.joker.sistofoodtest.Fragment.User;

/**
 * Created by joker on 15/2/18.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private FragmentManager fragmentManager;

    public ViewpagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.fragmentManager = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home();
            case 1:
                return new Status();
            case 2:
                return new User();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
