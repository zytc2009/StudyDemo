package com.example.studyproject.Serialize.bean.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class CommentItem implements Parcelable {

	private String id;
	private String content;
	private String replyId ;
	private String fromUserId;
	private String fromChildId;
	private String fromUserName;
	private String fromWxName;
	private String fromUserPic;

	private int fromMemberLevel;//评论者会员等级
	private int fromMemberStatus;
	private String toUserId;
	private String toChildId;
	private String toUserName;
	private String toWxName;
	private String toUserPic;
	private long createTime;

	private String fromUserType;
	private String toUserType;
	private String fromStudentId;
	private String toStudentId;

	private String fromCommentId;
	private String isTop;
	private String status;
	private String toContent;

	public int getFromMemberLevel() {
		return fromMemberLevel;
	}

	public void setFromMemberLevel(int fromMemberLevel) {
		this.fromMemberLevel = fromMemberLevel;
	}

	public int getFromMemberStatus() {
		return fromMemberStatus;
	}

	public void setFromMemberStatus(int fromMemberStatus) {
		this.fromMemberStatus = fromMemberStatus;
	}

	public String getFromCommentId() {
		return fromCommentId;
	}

	public void setFromCommentId(String fromCommentId) {
		this.fromCommentId = fromCommentId;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToContent() {
		return toContent;
	}

	public void setToContent(String toContent) {
		this.toContent = toContent;
	}

	public String getFromUserType() {
		return fromUserType;
	}

	public void setFromUserType(String fromUserType) {
		this.fromUserType = fromUserType;
	}

	public String getToUserType() {
		return toUserType;
	}

	public void setToUserType(String toUserType) {
		this.toUserType = toUserType;
	}

	public String getFromStudentId() {
		return fromStudentId;
	}

	public void setFromStudentId(String fromStudentId) {
		this.fromStudentId = fromStudentId;
	}

	public String getToStudentId() {
		return toStudentId;
	}

	public void setToStudentId(String toStudentId) {
		this.toStudentId = toStudentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getFromWxName() {
		return fromWxName;
	}

	public void setFromWxName(String fromWxName) {
		this.fromWxName = fromWxName;
	}

	public String getFromUserPic() {
		return fromUserPic;
	}

	public void setFromUserPic(String fromUserPic) {
		this.fromUserPic = fromUserPic;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getToWxName() {
		return toWxName;
	}

	public void setToWxName(String toWxName) {
		this.toWxName = toWxName;
	}

	public String getToUserPic() {
		return toUserPic;
	}

	public void setToUserPic(String toUserPic) {
		this.toUserPic = toUserPic;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getFromChildId() {
		return fromChildId;
	}

	public void setFromChildId(String fromChildId) {
		this.fromChildId = fromChildId;
	}

	public String getToChildId() {
		return toChildId;
	}

	public void setToChildId(String toChildId) {
		this.toChildId = toChildId;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.content);
		dest.writeString(this.replyId);
		dest.writeString(this.fromUserId);
		dest.writeString(this.fromChildId);
		dest.writeString(this.fromUserName);
		dest.writeString(this.fromWxName);
		dest.writeString(this.fromUserPic);
		dest.writeInt(this.fromMemberLevel);
		dest.writeInt(this.fromMemberStatus);
		dest.writeString(this.toUserId);
		dest.writeString(this.toChildId);
		dest.writeString(this.toUserName);
		dest.writeString(this.toWxName);
		dest.writeString(this.toUserPic);
		dest.writeLong(this.createTime);
		dest.writeString(this.fromUserType);
		dest.writeString(this.toUserType);
		dest.writeString(this.fromStudentId);
		dest.writeString(this.toStudentId);
		dest.writeString(this.fromCommentId);
		dest.writeString(this.isTop);
		dest.writeString(this.status);
		dest.writeString(this.toContent);
	}

	public CommentItem() {
	}

	protected CommentItem(Parcel in) {
		this.id = in.readString();
		this.content = in.readString();
		this.replyId = in.readString();
		this.fromUserId = in.readString();
		this.fromChildId = in.readString();
		this.fromUserName = in.readString();
		this.fromWxName = in.readString();
		this.fromUserPic = in.readString();
		this.fromMemberLevel = in.readInt();
		this.fromMemberStatus = in.readInt();
		this.toUserId = in.readString();
		this.toChildId = in.readString();
		this.toUserName = in.readString();
		this.toWxName = in.readString();
		this.toUserPic = in.readString();
		this.createTime = in.readLong();
		this.fromUserType = in.readString();
		this.toUserType = in.readString();
		this.fromStudentId = in.readString();
		this.toStudentId = in.readString();
		this.fromCommentId = in.readString();
		this.isTop = in.readString();
		this.status = in.readString();
		this.toContent = in.readString();
	}

	public static final Parcelable.Creator<CommentItem> CREATOR = new Parcelable.Creator<CommentItem>() {
		@Override
		public CommentItem createFromParcel(Parcel source) {
			return new CommentItem(source);
		}

		@Override
		public CommentItem[] newArray(int size) {
			return new CommentItem[size];
		}
	};
}
