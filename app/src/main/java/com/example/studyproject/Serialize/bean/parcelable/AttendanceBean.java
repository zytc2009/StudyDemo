package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @des:考勤
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version:
 * @date 2018/9/25 20:18
 */

public class AttendanceBean implements Parcelable {

    private String type;//考勤类型
    private String title;//考勤标题
    private String subTitle;//考勤子标题
    private List<BabyInfo> babyInfoList;//考勤宝宝信息

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public List<BabyInfo> getBabyInfoList() {
        return babyInfoList;
    }

    public void setBabyInfoList(List<BabyInfo> babyInfoList) {
        this.babyInfoList = babyInfoList;
    }

    public static class BabyInfo implements Serializable {
        private String babyId;//考勤宝宝Id
        private String studentId;//考勤学生Id
        private String babyName;//考勤宝宝名称
        private String sex;//考勤宝宝性别
        private ImagesBean babyPic;//考勤宝宝头像

        public String getBabyId() {
            return babyId;
        }

        public void setBabyId(String babyId) {
            this.babyId = babyId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getBabyName() {
            return babyName;
        }

        public void setBabyName(String babyName) {
            this.babyName = babyName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public ImagesBean getBabyPic() {
            return babyPic;
        }

        public void setBabyPic(ImagesBean babyPic) {
            this.babyPic = babyPic;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeString(this.subTitle);
        dest.writeList(this.babyInfoList);
    }

    public AttendanceBean() {
    }

    protected AttendanceBean(Parcel in) {
        this.type = in.readString();
        this.title = in.readString();
        this.subTitle = in.readString();
        this.babyInfoList = new ArrayList<BabyInfo>();
        in.readList(this.babyInfoList, BabyInfo.class.getClassLoader());
    }

    public static final Creator<AttendanceBean> CREATOR = new Creator<AttendanceBean>() {
        @Override
        public AttendanceBean createFromParcel(Parcel source) {
            return new AttendanceBean(source);
        }

        @Override
        public AttendanceBean[] newArray(int size) {
            return new AttendanceBean[size];
        }
    };
}
