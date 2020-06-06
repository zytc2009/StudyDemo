package com.example.studyproject.design.decoration;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(IComponent iComponent) {
        super(iComponent);
    }


    @Override
    public void operate() {
        operateA();
        super.operate();
        operateB();
    }

    public void operateA(){

    }

    public void operateB(){

    }
}
