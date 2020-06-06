package com.example.studyproject.Serialize.bean.serialize;

import java.io.Serializable;

public class ContentTagsBean implements Serializable {
    /**
     * tag : abc
     */
    private String tag;

    private int tagId;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ContentTagsBean{" +
                "tag='" + tag + '\'' +
                ", tagId=" + tagId +
                '}';
    }
}