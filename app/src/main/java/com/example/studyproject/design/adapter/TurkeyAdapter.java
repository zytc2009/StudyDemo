package com.example.studyproject.design.adapter;

public class TurkeyAdapter implements Duck {

    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        // 火鸡没有鸭子飞的远，因此多飞几次，达到适配鸭子fly的作用
        for(int i = 0 ;i < 5;i++) {
            turkey.fly();
        }
    }
}
