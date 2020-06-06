package com.example.studyproject.design.factorymethod;

import com.example.studyproject.design.simplefactory.Car;

public abstract class Factory {

    public abstract <T extends Car> T createCar(Class<T> clazz);

}
