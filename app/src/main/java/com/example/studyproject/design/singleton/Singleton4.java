package com.example.studyproject.design.singleton;

import java.io.Serializable;

/**
 * 静态内部类单例模式
 *
 * 第一次调用getInstance方法时虚拟机才加载SingletonHolder并初始化sInstance，
 * 这样保证了线程安全和实例的唯一性。
 * */
public class Singleton4 {

    private Singleton4(){}

    private static class SingletonHolder{
        private static Singleton4 singleton = new Singleton4();
    }

    public static Singleton4 getInstance(){
        return SingletonHolder.singleton;
    }


}
