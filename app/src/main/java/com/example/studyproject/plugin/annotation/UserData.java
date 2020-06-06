package com.example.studyproject.plugin.annotation;


import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UserData extends BaseData {

    @BindData(type = BindData.EnumType.FIELD,value = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //最终要用APT实现，AOP做替换
    @Override
    public UserData parseData(JSONObject data) {
        return this;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                '}';
    }
}
