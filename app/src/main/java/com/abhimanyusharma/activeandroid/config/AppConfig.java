package com.abhimanyusharma.activeandroid.config;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class AppConfig extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
