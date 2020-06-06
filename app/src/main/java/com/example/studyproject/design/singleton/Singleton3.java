package com.example.studyproject.design.singleton;

/**
 * 懒汉模式（DCL）
 * 第一次判空，省去了不必要的同步。第二次是在Singleton等于空时才创建实例。
 * 使用volatile保证了实例的可见性。
 * DCL在一定程度上解决了资源的消耗和多余的同步、线程安全等问题，但是在某些情况下会失效。
 *
 * DCL优点：资源利用率高，第一次执行getInstance时单例对象才会被实例化，效率高。
 *
 * 缺点：第一次加载稍慢，也由于JMM的原因导致偶尔会失败。在高并发环境下也有一定的缺陷，虽然发生概率很小。
 * DCL模式是使用最多的单例实现方式，它能够在需要时才实例化对象，并且能在绝大多数场景下保证对象的唯一性，
 * 除非你的代码在并发场景比较复杂或低于JDK1.6版本下使用，否则，这种方式一般能够满足要求。
 * */
public class Singleton3 {

    private static volatile Singleton3 singleton;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if (singleton == null){
            synchronized (Singleton3.class){
                if (singleton == null){
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
