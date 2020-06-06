package com.example.studyproject.Serialize.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class BookBean implements Parcelable {

    private String bookName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookName);
    }

    public BookBean() {
    }

    protected BookBean(Parcel in) {
        this.bookName = in.readString();
    }

    public static final Creator<BookBean> CREATOR = new Creator<BookBean>() {
        @Override
        public BookBean createFromParcel(Parcel source) {
            return new BookBean(source);
        }

        @Override
        public BookBean[] newArray(int size) {
            return new BookBean[size];
        }
    };
}
