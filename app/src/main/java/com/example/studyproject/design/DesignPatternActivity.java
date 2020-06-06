package com.example.studyproject.design;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyproject.R;

public class DesignPatternActivity extends AppCompatActivity {

    public static void start(Context context){
        Intent intent = new Intent(context, DesignPatternActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_design);
    }
}
