package com.example.studyproject.Serialize.bean.parcelable;


import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedContentBean implements Parcelable {
    private long publishTime;
    private String location;
    private String text;
    private List<ContentImagesBean> images;
    private List<String> imageUrls;
    private List<ContentAudioBean> audios;
    private List<ContentVideoBean> videos;
    private List<Link> links;
    private List<ContentTagsBean> tags;
    private Extend extend;
    private BodyFeatureBean bodyFeature;//身体特征
    private AttendanceBean attendance;//考勤
    /**
     * 6.15未完本提醒添加
     */
    private JSONObject jumpDatas;

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public AttendanceBean getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceBean attendance) {
        this.attendance = attendance;
    }

    public BodyFeatureBean getBodyFeature() {
        return bodyFeature;
    }

    public void setBodyFeature(BodyFeatureBean bodyFeature) {
        this.bodyFeature = bodyFeature;
    }

    public long getPublishTime() {
        return publishTime;
    }

    @Override
    public String toString() {
        return "FeedContentBean{" +
                "publishTime=" + publishTime +
                ", location='" + location + '\'' +
                ", text='" + text + '\'' +
                ", images=" + images +
                ", imageUrls=" + imageUrls +
                ", audios=" + audios +
                ", videos=" + videos +
                ", links=" + links +
                ", tags=" + tags +
                ", extend=" + extend +
                ", bodyFeature=" + bodyFeature +
                ", attendance=" + attendance +
                ", jumpDatas=" + jumpDatas +
                '}';
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ContentImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ContentImagesBean> images) {
        this.images = images;
        if (null != images){
            if (imageUrls == null){
                imageUrls = new ArrayList<>();
            }else{
                imageUrls.clear();
            }
            for (ContentImagesBean img : images) {
                imageUrls.add(img.getImageUrl());
            }
        }
    }

    public List<ContentVideoBean> getVideos() {
        return videos;
    }

    public void setVideos(List<ContentVideoBean> videos) {
        this.videos = videos;
    }

    public List<ContentAudioBean> getAudios() {
        return audios;
    }

    public void setAudios(List<ContentAudioBean> audios) {
        this.audios = audios;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<ContentTagsBean> getTags() {
        return tags;
    }

    public void setTags(List<ContentTagsBean> tags) {
        this.tags = tags;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }

    public static class Link {

        private String url;
        private String title;
        private String subTitle;
        private int type;
        private ImagesBean image;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public ImagesBean getImage() {
            return image;
        }

        public void setImage(ImagesBean image) {
            this.image = image;
        }
    }

    public static class Extend implements Serializable {
        private String templateMark;
        private String source;
        private String studentId;
        private String classId;
        private String appVersion;
        private int pkType;
        private boolean faceImage;//是否是人脸识别图片 true：是；false：否；
        private int showType;// 1 统一跳转链接，大图展示样式  661新增
        private String schoolName;//课程内容分享 需要展示学校名称
        /**
         * version 6.22 判断是否是相同每日推荐使用数据
         * 用于数据的组装
         */
        private DailyRecommendBean dailyRecommend;

        public boolean isFaceImage() {
            return faceImage;
        }

        public void setFaceImage(boolean faceImage) {
            this.faceImage = faceImage;
        }

        public int getShowType() {
            return showType;
        }

        public void setShowType(int showType) {
            this.showType = showType;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getTemplateMark() {
            return templateMark;
        }

        public void setTemplateMark(String templateMark) {
            this.templateMark = templateMark;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public int getPkType() {
            return pkType;
        }

        public void setPkType(int pkType) {
            this.pkType = pkType;
        }

        public DailyRecommendBean getDailyRecommend() {
            return dailyRecommend;
        }

        public void setDailyRecommend(DailyRecommendBean dailyRecommend) {
            this.dailyRecommend = dailyRecommend;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }
    }

    public JSONObject getJumpDatas() {
        return jumpDatas;
    }

    public void setJumpDatas(JSONObject jumpDatas) {
        this.jumpDatas = jumpDatas;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.publishTime);
        dest.writeString(this.location);
        dest.writeString(this.text);
        dest.writeTypedList(this.images);
        dest.writeStringList(this.imageUrls);
        dest.writeTypedList(this.audios);
        dest.writeTypedList(this.videos);
        dest.writeList(this.links);
        dest.writeTypedList(this.tags);
        dest.writeSerializable(this.extend);
        dest.writeParcelable(this.bodyFeature, flags);
        dest.writeParcelable(this.attendance, flags);
    }

    public FeedContentBean() {
    }

    protected FeedContentBean(Parcel in) {
        this.publishTime = in.readLong();
        this.location = in.readString();
        this.text = in.readString();
        this.images = in.createTypedArrayList(ContentImagesBean.CREATOR);
        this.imageUrls = in.createStringArrayList();
        this.audios = in.createTypedArrayList(ContentAudioBean.CREATOR);
        this.videos = in.createTypedArrayList(ContentVideoBean.CREATOR);
        this.links = new ArrayList<Link>();
        in.readList(this.links, Link.class.getClassLoader());
        this.tags = in.createTypedArrayList(ContentTagsBean.CREATOR);
        this.extend = (Extend) in.readSerializable();
        this.bodyFeature = in.readParcelable(BodyFeatureBean.class.getClassLoader());
        this.attendance = in.readParcelable(AttendanceBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<FeedContentBean> CREATOR = new Parcelable.Creator<FeedContentBean>() {
        @Override
        public FeedContentBean createFromParcel(Parcel source) {
            return new FeedContentBean(source);
        }

        @Override
        public FeedContentBean[] newArray(int size) {
            return new FeedContentBean[size];
        }
    };
}