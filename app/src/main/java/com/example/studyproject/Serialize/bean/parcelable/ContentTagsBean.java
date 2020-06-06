package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ContentTagsBean implements Parcelable {
    /**
     * tag : abc
     */
    private String tag;

    private int tagId;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ContentTagsBean{" +
                "tag='" + tag + '\'' +
                ", tagId=" + tagId +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tag);
        dest.writeInt(this.tagId);
    }

    public ContentTagsBean() {
    }

    protected ContentTagsBean(Parcel in) {
        this.tag = in.readString();
        this.tagId = in.readInt();
    }

    public static final Parcelable.Creator<ContentTagsBean> CREATOR = new Parcelable.Creator<ContentTagsBean>() {
        @Override
        public ContentTagsBean createFromParcel(Parcel source) {
            return new ContentTagsBean(source);
        }

        @Override
        public ContentTagsBean[] newArray(int size) {
            return new ContentTagsBean[size];
        }
    };
}