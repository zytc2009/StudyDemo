package com.example.studyproject.Serialize.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class BaseTypeBean implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public BaseTypeBean() {
    }

    protected BaseTypeBean(Parcel in) {
    }

    public static final Creator<BaseTypeBean> CREATOR = new Creator<BaseTypeBean>() {
        @Override
        public BaseTypeBean createFromParcel(Parcel source) {
            return new BaseTypeBean(source);
        }

        @Override
        public BaseTypeBean[] newArray(int size) {
            return new BaseTypeBean[size];
        }
    };
}