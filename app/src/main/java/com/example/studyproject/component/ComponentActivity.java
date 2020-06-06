package com.example.studyproject.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.studyproject.R;

@Route(path = "/main/component")
public class ComponentActivity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context){
        Intent intent = new Intent(context,ComponentActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_component);

        findViewById(R.id.jump_router).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jump_router:
                ARouter.getInstance()
                        .build("/router/routermodel1")
                        .navigation();
                break;
        }
    }
}

