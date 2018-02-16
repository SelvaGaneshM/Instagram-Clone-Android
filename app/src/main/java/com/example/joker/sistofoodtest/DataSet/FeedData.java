package com.example.joker.sistofoodtest.DataSet;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by joker on 15/2/18.
 */

public class FeedData {


    public static String getJsonData(Context context) {

        String json = null;
        try {
            InputStream is = context.getAssets().open("test.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }
}
