package com.example.studyproject.design.decoration;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(IComponent iComponent) {
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
