package com.example.studyproject.Serialize.bean.serialize;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version:
 * @date 2018/6/25 20:14
 */

public class ContentVideoBean implements Serializable {

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
}
