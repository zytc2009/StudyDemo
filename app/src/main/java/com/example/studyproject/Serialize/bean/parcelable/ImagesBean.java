package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ImagesBean implements Parcelable {
    /**
     * image : url1
     */
    private String imageUrl;
    private int width;
    private int height;

    public ImagesBean() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    protected ImagesBean(Parcel in) {
        this.imageUrl = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Parcelable.Creator<ImagesBean> CREATOR = new Parcelable.Creator<ImagesBean>() {
        @Override
        public ImagesBean createFromParcel(Parcel source) {
            return new ImagesBean(source);
        }

        @Override
        public ImagesBean[] newArray(int size) {
            return new ImagesBean[size];
        }
    };
}

