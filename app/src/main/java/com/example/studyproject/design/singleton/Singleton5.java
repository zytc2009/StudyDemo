package com.example.studyproject.design.singleton;

/**
 * 枚举单例
 *
 * 默认枚举实例的创建是线程安全的，并且在任何情况下都是单例。
 * 简单、可读性不高。
 * */
public enum  Singleton5 {

    INSTANCE;
    public void doSomeThing() {
    }

}
