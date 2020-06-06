package com.example.studyproject.design.proxy;

public class ShopProxy implements IShop {

    IShop shop;

    public ShopProxy(IShop iShop){
        this.shop = iShop;
    }

    @Override
    public void buy(){
        System.out.println("ShopProxy:buy");
        if (isBuy()){
            shop.buy();
        }
    }

    private boolean isBuy(){
        return true;
    }
}
