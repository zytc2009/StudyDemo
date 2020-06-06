package com.example.studyproject.design.build;

public abstract class Builder {

    abstract PhoneBuilder buildBrand(String brand);
    abstract PhoneBuilder buildColor(String color);
    abstract PhoneBuilder buildSize(String size);

}
