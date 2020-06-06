package com.example.studyproject.Serialize.bean.serialize;

import java.io.Serializable;

/**
 * 每日推荐 - 判断是否是相同推荐内容的数据结构
 * Created by gjl on 2020/2/14.
 * Version: 6.22.1
 */
public class DailyRecommendBean implements Serializable{

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
}
