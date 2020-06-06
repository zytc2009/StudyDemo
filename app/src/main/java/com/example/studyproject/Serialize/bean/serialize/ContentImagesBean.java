package com.example.studyproject.Serialize.bean.serialize;


import java.io.Serializable;
import java.util.List;

public class ContentImagesBean implements Serializable{
    /**
     * image : url1
     */
    private String imageUrl;

    private int width;

    private int height;
    /**
     * 6.6.1新增人脸识别信息
     * */
    private List<BabyInfo> babyInfoList;

    /**
     * 增加显示缩略图的地址和宽高
     * 此字段不是服务器返回。在展示时，设置。用于预览使用
     */
    private String thumbImgUrl;

    private int thumbWidth;

    private int thumbHeight;
    /**
     * 6.6.1增加图片人脸识别结果中是否有当前宝宝
     * 此字段不是服务器返回，用于大图展示
     */
    private boolean isFaceRecogHasCurrentBaby;

    public boolean isFaceRecogHasCurrentBaby() {
        return isFaceRecogHasCurrentBaby;
    }


    private long photoTime;//拍照时间 6.14.1新增

    private String longitude;//经度 6.14.1新增

    private String latitude;//纬度 6.14.1新增

    private String location;//照片位置信息 6.14.1新增

    /**
     * 原图宽 6.15.1新增
     */
    private int originWidth;
    /**
     * 原图高 6.15.1新增
     */
    private int originHeight;
    /**
     * 原图大小 byte 6.15.1新增
     */
    private long originSize;
    /**
     * 是否压缩图片 6.15.1新增
     */
    private boolean compressImage;
    /**
     * 处理后图片大小 byte  6.15.1新增
     */
    private long size;

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

    public void setFaceRecogHasCurrentBaby(boolean faceRecogHasCurrentBaby) {
        isFaceRecogHasCurrentBaby = faceRecogHasCurrentBaby;
    }

    public static class BabyInfo implements Serializable {
        private String babyId;
        private String babyName;

        public String getBabyId() {
            return babyId;
        }

        public void setBabyId(String babyId) {
            this.babyId = babyId;
        }

        public String getBabyName() {
            return babyName;
        }

        public void setBabyName(String babyName) {
            this.babyName = babyName;
        }
    }

    public List<BabyInfo> getBabyInfoList() {
        return babyInfoList;
    }

    public void setBabyInfoList(List<BabyInfo> babyInfoList) {
        this.babyInfoList = babyInfoList;
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

    public String getThumbImgUrl() {
        return thumbImgUrl;
    }

    public void setThumbImgUrl(String thumbImgUrl) {
        this.thumbImgUrl = thumbImgUrl;
    }

    public int getThumbWidth() {
        return thumbWidth;
    }

    public void setThumbWidth(int thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    public int getThumbHeight() {
        return thumbHeight;
    }

    public void setThumbHeight(int thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

    public int getOriginWidth() {
        return originWidth;
    }

    public void setOriginWidth(int originWidth) {
        this.originWidth = originWidth;
    }

    public int getOriginHeight() {
        return originHeight;
    }

    public void setOriginHeight(int originHeight) {
        this.originHeight = originHeight;
    }

    public long getOriginSize() {
        return originSize;
    }

    public void setOriginSize(long originSize) {
        this.originSize = originSize;
    }

    public boolean isCompressImage() {
        return compressImage;
    }

    public void setCompressImage(boolean compressImage) {
        this.compressImage = compressImage;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}