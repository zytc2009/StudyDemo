package com.example.studyproject.design.simplefactory;

import android.util.Log;

public class BCar extends Car {

    private static final String TAG = BCar.class.getSimpleName();

    @Override
    public void start() {
        Log.d(TAG, "BCar start ...");
    }
}
