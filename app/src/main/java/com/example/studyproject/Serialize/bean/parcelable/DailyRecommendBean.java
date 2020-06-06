package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 每日推荐 - 判断是否是相同推荐内容的数据结构
 * Created by gjl on 2020/2/14.
 * Version: 6.22.1
 */
public class DailyRecommendBean implements Parcelable {

    private String recommendId; //主要使用的比较字段，推荐id

    private String lightspot ; // 亮点 （推荐语）

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public String getLightspot() {
        return lightspot;
    }

    public void setLightspot(String lightspot) {
        this.lightspot = lightspot;
    }

    @Override
    public String toString() {
        return "DailyRecommendBean{" +
                "recommendId='" + recommendId + '\'' +
                ", lightspot='" + lightspot + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recommendId);
        dest.writeString(this.lightspot);
    }

    public DailyRecommendBean() {
    }

    protected DailyRecommendBean(Parcel in) {
        this.recommendId = in.readString();
        this.lightspot = in.readString();
    }

    public static final Parcelable.Creator<DailyRecommendBean> CREATOR = new Parcelable.Creator<DailyRecommendBean>() {
        @Override
        public DailyRecommendBean createFromParcel(Parcel source) {
            return new DailyRecommendBean(source);
        }

        @Override
        public DailyRecommendBean[] newArray(int size) {
            return new DailyRecommendBean[size];
        }
    };
}
