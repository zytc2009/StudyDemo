package com.example.studyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.studyproject.Serialize.SerializeDemo;
import com.example.studyproject.component.ComponentActivity;
import com.example.studyproject.design.DesignPatternActivity;
import com.example.studyproject.plugin.annotation.GradeData;
import com.example.studyproject.plugin.annotation.UserData;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 组件化
     * */
    public void onClickComponent(View view) {
        ComponentActivity.start(this);
    }

    /**
     * 设计模式
     * */
    public void onClickDesign(View view) {
        DesignPatternActivity.start(this);
    }

    /**
     * 算法
     * */
    public void onClickArithmetic(View view) {
        //ArithmeticDemo
    }

    /**
     * 序列化
     * */
    public void onClickSerialize(View view) {
        SerializeDemo.start(this);
    }


    public void onClickASM(View view) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "wyc");
            jsonObject.put("age",20);
            jsonObject.put("time",1591283816000L);
            jsonObject.put("isSelect",true);
            jsonObject.put("money",2.56);

            JSONObject userObject = new JSONObject();
            userObject.put("name","zsj");

            jsonObject.put("userData", userObject);
            GradeData gradeData = new GradeData().parseData(jsonObject);
            System.out.println(gradeData);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
