package com.example.studyproject.design.observer;

public class Client {

    public static void main(String[] args) {
        Subscription subscription = new Subscription();

        WeXinUser weXinUser = new WeXinUser();

        subscription.addObserver(weXinUser);
        subscription.change("发生变化");
    }



}
