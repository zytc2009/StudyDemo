package com.example.studyproject.design.decoration;

public abstract class Decorator implements IComponent {

    private IComponent iComponent;

    public Decorator(IComponent iComponent){
        this.iComponent = iComponent;
    }

    @Override
    public void operate() {
        System.out.println("Decorator : operate ...");
        iComponent.operate();
    }
}
