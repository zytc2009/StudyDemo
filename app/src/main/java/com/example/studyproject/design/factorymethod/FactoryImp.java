package com.example.studyproject.design.factorymethod;

import com.example.studyproject.design.simplefactory.Car;

/**
 * 工厂方法模式
 * 相比简单工厂，如果我们需要新增产品类，无需修改工厂类，直接创建产品即可。
 * */
public class FactoryImp extends Factory{

    @Override
    public <T extends Car> T createCar(Class<T> clazz) {
        Car car = null;
        String clazzName = clazz.getName();

        try {
            car = (Car) Class.forName(clazzName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) car;
    }
}
