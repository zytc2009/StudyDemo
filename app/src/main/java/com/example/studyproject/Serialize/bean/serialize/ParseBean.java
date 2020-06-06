package com.example.studyproject.Serialize.bean.serialize;

import com.example.studyproject.Serialize.bean.BaseTypeBean;
import com.example.studyproject.Serialize.bean.serialize.FeedCommentsBean;
import com.example.studyproject.Serialize.bean.serialize.FeedContentBean;
import com.example.studyproject.Serialize.bean.serialize.ImagesBean;

public class ParseBean extends BaseTypeBean {

    private String contentId;//信息流内容id
    private String contentType;//信息流内容type
    private int originType;//分享到信息流的原系统类型
    private String userId;//发布信息人的用户id（发布这条信息的id）
    private int roleType;//0系统默认    1管理员    2亲友    3创建者   4	老师    5园长
    private int state;//印记状态
    private String name;
    private String relation;
    private String jobName;//园丁端 老师职位
    private int visible;
    private ImagesBean userPic;
    private String schoolId;
    private String classId;
    private String studentId;
    private String babyId;
    private FeedContentBean content;
    private boolean canCollect;//是否可以搜藏（校园页必须）；true 可以搜藏；false：不能搜藏；
    private FeedCommentsBean feedCommentsBean;
    private boolean stickyPost;

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getOriginType() {
        return originType;
    }

    public void setOriginType(int originType) {
        this.originType = originType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public ImagesBean getUserPic() {
        return userPic;
    }

    public void setUserPic(ImagesBean userPic) {
        this.userPic = userPic;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBabyId() {
        return babyId;
    }

    public void setBabyId(String babyId) {
        this.babyId = babyId;
    }

    public FeedContentBean getContent() {
        return content;
    }

    public void setContent(FeedContentBean content) {
        this.content = content;
    }

    public boolean isCanCollect() {
        return canCollect;
    }

    public void setCanCollect(boolean canCollect) {
        this.canCollect = canCollect;
    }

    public FeedCommentsBean getFeedCommentsBean() {
        return feedCommentsBean;
    }

    public void setFeedCommentsBean(FeedCommentsBean feedCommentsBean) {
        this.feedCommentsBean = feedCommentsBean;
    }

    public boolean isStickyPost() {
        return stickyPost;
    }

    public void setStickyPost(boolean stickyPost) {
        this.stickyPost = stickyPost;
    }
}
