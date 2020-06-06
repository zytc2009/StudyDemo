package com.example.studyproject.design.simplefactory;

/**
 * 静态工厂模式
 *
 * 它需要知道所有工厂类型，因此只适合工厂类负责创建的对象比较少的情况。
 * 避免直接实例化类，降低耦合性。
 * 增加新产品需要修改工厂，违背开放封闭原则。
 * */
public class Factory {

    private static Car car ;

    public static Car getFactory(int type){
        switch (type){
            case 1:
                car = new ACar();
                break;
            case 2:
                car = new BCar();
                break;
        }
        return car;
    }

}
