package com.example.studyproject.Serialize.bean.serialize;

import java.io.Serializable;

/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version:
 * @date 2018/9/25 20:18
 */

public class BodyFeatureBean implements Serializable {

    private long measureTime;//测量时间
    private int type;//1:身高；2：体温；
    private String sex;//性别
    private String height;//身高
    private String weight;//体重
    private String temperature;//温度
    private String condition;//正常 ；异常
    private ImagesBean babyPic;

    public long getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(long measureTime) {
        this.measureTime = measureTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ImagesBean getBabyPic() {
        return babyPic;
    }

    public void setBabyPic(ImagesBean babyPic) {
        this.babyPic = babyPic;
    }
    public void setBabyPic(String babyPic) {
        ImagesBean imagesBean = new ImagesBean();
        imagesBean.setImageUrl(babyPic);
        this.babyPic = imagesBean;
    }
}
