package com.example.studyproject.design.singleton;

/**
 * 懒汉模式（线程安全）
 * 为了处理并发，每次调用getInstance方法时都需要进行同步，会有不必要的同步开销。
 * */
public class Singleton2 {

    private static Singleton2 singleton;

    private Singleton2(){}

    public synchronized static Singleton2 getInstance(){
        if (singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }
}
