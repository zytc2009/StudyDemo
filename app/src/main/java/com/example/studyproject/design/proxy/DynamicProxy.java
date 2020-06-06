package com.example.studyproject.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * */
public class DynamicProxy implements InvocationHandler {

    private IShop shop;
    public DynamicProxy(IShop shop){
        this.shop = shop;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(shop, objects);
    }
}
