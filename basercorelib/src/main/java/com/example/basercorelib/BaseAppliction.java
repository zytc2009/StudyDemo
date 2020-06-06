package com.example.basercorelib;

import android.app.Application;

public abstract class BaseAppliction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        init();

    }

    public abstract void init();
}
