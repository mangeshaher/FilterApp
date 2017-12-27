package com.example.mangeshaher.softapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by mangeshaher on 29/10/17.
 */

public class FireApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
