package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version:
 * @date 2018/6/25 20:14
 */

public class ContentVideoBean implements Parcelable {

    /**
     * videoUrl : http://
     * videoCoverUrl : http://
     */

    private String videoUrl;

    private ImagesBean coverImage;

    private String localvideopath;  //本地的存储的路径 (非服务器字段)

    private String taskId;  //非服务器返回数据  本地下载视频时任务的id  (未避免重复 使用 contentid 和contenttype和feedId 结合)

    private String width;

    private String height;
    /**
     * 秒
     */
    private String duration;

    private long photoTime;

    private String longitude;

    private String latitude;

    private String location;

    public long getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(long photoTime) {
        this.photoTime = photoTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWidth() {
        return width;
    }

    public int getWidthInt() {
        if (TextUtils.isEmpty(width)) {
            return 0;
        }
        try {
            return Integer.valueOf(width);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }


    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public int getHeightInt() {
        if (TextUtils.isEmpty(height)) {
            return 0;
        }
        try {
            return Integer.valueOf(height);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDuration() {
        return duration;
    }

    public long getDurationLong() {
        if (TextUtils.isEmpty(duration)) {
            return 0L;
        }
        try {
            return Long.valueOf(duration);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getLocalvideopath() {

        return localvideopath;
    }

    public void setLocalvideopath(String localvideopath) {
        this.localvideopath = localvideopath;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public ImagesBean getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImagesBean coverImage) {
        this.coverImage = coverImage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.videoUrl);
        dest.writeParcelable(this.coverImage, flags);
        dest.writeString(this.localvideopath);
        dest.writeString(this.taskId);
        dest.writeString(this.width);
        dest.writeString(this.height);
        dest.writeString(this.duration);
        dest.writeLong(this.photoTime);
        dest.writeString(this.longitude);
        dest.writeString(this.latitude);
        dest.writeString(this.location);
    }

    public ContentVideoBean() {
    }

    protected ContentVideoBean(Parcel in) {
        this.videoUrl = in.readString();
        this.coverImage = in.readParcelable(ImagesBean.class.getClassLoader());
        this.localvideopath = in.readString();
        this.taskId = in.readString();
        this.width = in.readString();
        this.height = in.readString();
        this.duration = in.readString();
        this.photoTime = in.readLong();
        this.longitude = in.readString();
        this.latitude = in.readString();
        this.location = in.readString();
    }

    public static final Parcelable.Creator<ContentVideoBean> CREATOR = new Parcelable.Creator<ContentVideoBean>() {
        @Override
        public ContentVideoBean createFromParcel(Parcel source) {
            return new ContentVideoBean(source);
        }

        @Override
        public ContentVideoBean[] newArray(int size) {
            return new ContentVideoBean[size];
        }
    };
}
