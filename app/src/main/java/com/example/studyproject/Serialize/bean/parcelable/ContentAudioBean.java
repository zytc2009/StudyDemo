package com.example.studyproject.Serialize.bean.parcelable;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * @des:
 * @author: hudan
 * @e-mail: hudan@szy.cn
 * @version:
 * @date 2018/6/25 20:18
 */

public class ContentAudioBean implements Parcelable {

    /**
     * title : title
     * duration : 100
     * audioUrl : audioUrl
     */

    private String audioUrl;
    private long duration;
    private String title;
    private int type;
    private String templateId;
    /**
     * 增加字段，记录播放位置状态
     */
    private int playingSecond;
    private boolean isPlaying;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public int getPlayingSecond() {
        return playingSecond;
    }

    public void setPlayingSecond(int playingSecond) {
        this.playingSecond = playingSecond;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Override
    public String toString() {
        return "ContentAudioBean{" +
                "audioUrl='" + audioUrl + '\'' +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                ", playingSecond=" + playingSecond +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.audioUrl);
        dest.writeLong(this.duration);
        dest.writeString(this.title);
        dest.writeInt(this.type);
        dest.writeString(this.templateId);
        dest.writeInt(this.playingSecond);
        dest.writeByte(this.isPlaying ? (byte) 1 : (byte) 0);
    }

    public ContentAudioBean() {
    }

    protected ContentAudioBean(Parcel in) {
        this.audioUrl = in.readString();
        this.duration = in.readLong();
        this.title = in.readString();
        this.type = in.readInt();
        this.templateId = in.readString();
        this.playingSecond = in.readInt();
        this.isPlaying = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ContentAudioBean> CREATOR = new Parcelable.Creator<ContentAudioBean>() {
        @Override
        public ContentAudioBean createFromParcel(Parcel source) {
            return new ContentAudioBean(source);
        }

        @Override
        public ContentAudioBean[] newArray(int size) {
            return new ContentAudioBean[size];
        }
    };
}
