package com.example.studyproject.design.singleton;

/**
 * 饿汉模式
 * 在类加载的时候就完成实例化，如果从始至终未使用这个实例，则会造成内存的浪费。
 * */
public class Singleton1 {

    private static Singleton1 singleton = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return singleton;
    }

    //反序列化时,防止对象重复创建
    private Object readReslove(){//当从流中读取实例时需要指定替换的类应实现具有确切签名的特殊方法。
        return singleton;
    }
}
