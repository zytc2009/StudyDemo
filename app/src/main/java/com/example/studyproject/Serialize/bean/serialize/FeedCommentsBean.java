package com.example.studyproject.Serialize.bean.serialize;

import java.io.Serializable;
import java.util.List;

/**
 * @des:
 * @author: wyc
 * @e-mail: wangyongchao@szy.cn
 * @version: 6.0
 * @date 2018/4/27 13:11
 */

public class FeedCommentsBean implements Serializable {

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


}
