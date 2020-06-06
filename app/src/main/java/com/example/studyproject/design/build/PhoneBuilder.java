package com.example.studyproject.design.build;

public class PhoneBuilder extends Builder {

    private String brand;
    private String color;
    private String size;

    @Override
    public PhoneBuilder buildBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public PhoneBuilder buildColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public PhoneBuilder buildSize(String size) {
        this.size = size;
        return this;
    }

    public PhoneBean create(){
        PhoneBean phoneBean = new PhoneBean();
        phoneBean.setBrand(brand);
        phoneBean.setSize(size);
        phoneBean.setColor(color);
        return phoneBean;
    }

}
