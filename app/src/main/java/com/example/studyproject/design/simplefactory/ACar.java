package com.example.studyproject.design.simplefactory;

import android.util.Log;

public class ACar extends Car {

    private static final String TAG = ACar.class.getSimpleName();

    @Override
    public void start() {
        Log.d(TAG, "ACar start ...");
    }
}
