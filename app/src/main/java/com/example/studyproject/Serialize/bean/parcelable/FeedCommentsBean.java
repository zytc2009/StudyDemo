package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version: 6.0
 * @date 2018/4/27 13:11
 */

public class FeedCommentsBean implements Parcelable {

    private int likeCount; //点赞数
    private int commentCount; //评论数
    private int commentDisable;//为1的话表示屏蔽
    private int viewCount; //浏览数
    private int shareCount;
    private int likeState;//点赞状态  是否点过赞1为点过0没有
    private List<CommentLike> likeList;
    private List<CommentItem> comments;

    public int getCommentDisable() {
        return commentDisable;
    }

    public void setCommentDisable(int commentDisable) {
        this.commentDisable = commentDisable;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getLikeState() {
        return likeState;
    }

    public void setLikeState(int likeState) {
        this.likeState = likeState;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public List<CommentLike> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<CommentLike> likeList) {
        this.likeList = likeList;
    }

    public List<CommentItem> getComments() {
        return comments;
    }

    public void setComments(List<CommentItem> comments) {
        this.comments = comments;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.likeCount);
        dest.writeInt(this.commentCount);
        dest.writeInt(this.commentDisable);
        dest.writeInt(this.viewCount);
        dest.writeInt(this.shareCount);
        dest.writeInt(this.likeState);
        dest.writeTypedList(this.likeList);
        dest.writeTypedList(this.comments);
    }

    public FeedCommentsBean() {
    }

    protected FeedCommentsBean(Parcel in) {
        this.likeCount = in.readInt();
        this.commentCount = in.readInt();
        this.commentDisable = in.readInt();
        this.viewCount = in.readInt();
        this.shareCount = in.readInt();
        this.likeState = in.readInt();
        this.likeList = in.createTypedArrayList(CommentLike.CREATOR);
        this.comments = in.createTypedArrayList(CommentItem.CREATOR);
    }

    public static final Parcelable.Creator<FeedCommentsBean> CREATOR = new Parcelable.Creator<FeedCommentsBean>() {
        @Override
        public FeedCommentsBean createFromParcel(Parcel source) {
            return new FeedCommentsBean(source);
        }

        @Override
        public FeedCommentsBean[] newArray(int size) {
            return new FeedCommentsBean[size];
        }
    };
}
