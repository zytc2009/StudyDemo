package com.example.studyproject.design.proxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        IShop shop = new ShopImp();
        DynamicProxy dynamicProxy = new DynamicProxy(shop);
        ClassLoader classLoader = shop.getClass().getClassLoader();

        IShop shop1 = (IShop) Proxy.newProxyInstance(classLoader, new Class[]{IShop.class}, dynamicProxy);
        shop1.buy();
    }

}
