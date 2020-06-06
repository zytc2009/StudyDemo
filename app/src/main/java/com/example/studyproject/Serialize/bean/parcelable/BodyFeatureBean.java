package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version:
 * @date 2018/9/25 20:18
 */

public class BodyFeatureBean implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.measureTime);
        dest.writeInt(this.type);
        dest.writeString(this.sex);
        dest.writeString(this.height);
        dest.writeString(this.weight);
        dest.writeString(this.temperature);
        dest.writeString(this.condition);
        dest.writeParcelable(this.babyPic, flags);
    }

    public BodyFeatureBean() {
    }

    protected BodyFeatureBean(Parcel in) {
        this.measureTime = in.readLong();
        this.type = in.readInt();
        this.sex = in.readString();
        this.height = in.readString();
        this.weight = in.readString();
        this.temperature = in.readString();
        this.condition = in.readString();
        this.babyPic = in.readParcelable(ImagesBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<BodyFeatureBean> CREATOR = new Parcelable.Creator<BodyFeatureBean>() {
        @Override
        public BodyFeatureBean createFromParcel(Parcel source) {
            return new BodyFeatureBean(source);
        }

        @Override
        public BodyFeatureBean[] newArray(int size) {
            return new BodyFeatureBean[size];
        }
    };
}
