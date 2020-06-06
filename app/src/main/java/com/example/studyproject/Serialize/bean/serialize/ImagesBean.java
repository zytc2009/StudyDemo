package com.example.studyproject.Serialize.bean.serialize;

import java.io.Serializable;

public class ImagesBean implements Serializable {
    /**
     * image : url1
     */
    private String imageUrl;
    private int width;
    private int height;

    public ImagesBean() {
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
}