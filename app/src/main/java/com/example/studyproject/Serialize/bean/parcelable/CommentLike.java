package com.example.studyproject.Serialize.bean.parcelable;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dan on 2016/9/11.
 */
public class CommentLike implements Parcelable {

    private String userId;
    private String childId;
    private String userName;
    private String wxName;
    private String userPic;

    private String userType;
    private String studentId;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.childId);
        dest.writeString(this.userName);
        dest.writeString(this.wxName);
        dest.writeString(this.userPic);
        dest.writeString(this.userType);
        dest.writeString(this.studentId);
    }

    public CommentLike() {
    }

    protected CommentLike(Parcel in) {
        this.userId = in.readString();
        this.childId = in.readString();
        this.userName = in.readString();
        this.wxName = in.readString();
        this.userPic = in.readString();
        this.userType = in.readString();
        this.studentId = in.readString();
    }

    public static final Parcelable.Creator<CommentLike> CREATOR = new Parcelable.Creator<CommentLike>() {
        @Override
        public CommentLike createFromParcel(Parcel source) {
            return new CommentLike(source);
        }

        @Override
        public CommentLike[] newArray(int size) {
            return new CommentLike[size];
        }
    };
}
