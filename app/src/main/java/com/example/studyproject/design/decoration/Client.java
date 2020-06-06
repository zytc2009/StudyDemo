package com.example.studyproject.design.decoration;

public class Client {

    public static void main(String[] args) {
        IComponent component = new ConcreteComponent();

        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operate();

        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(component);
        decoratorB.operate();
    }

}
