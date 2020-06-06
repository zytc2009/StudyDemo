package com.example.studyproject.plugin.annotation;
import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GradeData extends BaseData {

    @BindData(type = BindData.EnumType.FIELD,value = "name")
    private String name;
    @BindData(type = BindData.EnumType.FIELD,value = "age")
    private int age;
    @BindData(type = BindData.EnumType.FIELD,value = "time")
    private long time;
    @BindData(type = BindData.EnumType.FIELD,value = "isSelect")
    private boolean isSelect;
    @BindData(type = BindData.EnumType.FIELD,value = "money")
    private double money;


    @BindData(type = BindData.EnumType.OBJECT,value = "userData")
    private UserData userData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

//    //最终要用APT实现，AOP做替换
    @Override
    public  GradeData parseData(JSONObject data) {
//        parse(data);
        return this;
    }


    /**
     * 需要生成字节码的代码
     * */
    private void parse(JSONObject data) throws Exception{

        Class clazz = Class.forName("com.example.studyproject.plugin.annotation.GradeData");

        Field[] clazzFields = clazz.getDeclaredFields();
        for (Field field : clazzFields) {

            BindData annotation = field.getAnnotation(BindData.class);
            if (annotation == null) {
                continue;
            }

            String typeClassName = field.getType().getName();
            String key = annotation.value();

            if (annotation.type() == BindData.EnumType.FIELD) {

                if (typeClassName.equals(String.class.getName())) {
                    String fieldVaule = data.optString(key);
                    field.set(this, fieldVaule);
                }else if (typeClassName.equals(int.class.getName())){
                    int intValue = data.optInt(key);
                    field.set(this, intValue);
                }else if (typeClassName.equals(long.class.getName())){
                    long longValue = data.optLong(key);
                    field.set(this, longValue);
                }else if (typeClassName.equals(double.class.getName())){
                    double doubleValue = data.optDouble(key);
                    field.set(this, doubleValue);
                }else if (typeClassName.equals(boolean.class.getName())){
                    boolean booleanValue = data.optBoolean(key);
                    field.set(this, booleanValue);
                }

            } else if (annotation.type() == BindData.EnumType.OBJECT) {

                Class typeClass = Class.forName(typeClassName);
                Object object = typeClass.newInstance();

                Method method = typeClass.getDeclaredMethod("parseData", JSONObject.class);
                method.setAccessible(true);
                method.invoke(object, data.getJSONObject(key));

                field.set(this, object);
            }

        }

    }


    @Override
    public String toString() {
        return "GradeData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", time=" + time +
                ", isSelect=" + isSelect +
                ", money=" + money +
                ", userData=" + userData +
                '}';
    }
}
