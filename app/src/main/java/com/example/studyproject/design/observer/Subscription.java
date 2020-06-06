package com.example.studyproject.design.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArraySet;

public class Subscription extends Observable {


    public void change(String content){
        setChanged();
        notifyObservers(content);
    }

}