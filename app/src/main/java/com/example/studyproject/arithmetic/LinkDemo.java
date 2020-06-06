package com.example.studyproject.arithmetic;

import com.example.studyproject.arithmetic.bean.DoubleLinkList;
import com.example.studyproject.arithmetic.bean.SingleLinkList;

/**
 * 单链表练习
 * */
public class LinkDemo {

    public static void main(String[] args) {

//        singleLinkTest();

        doubleLinkTest();
    }

    private static void singleLinkTest(){
        SingleLinkList linkList = new SingleLinkList();
        linkList.insertFirst(10);
        linkList.insertFirst(20);
        linkList.insertFirst(30);

        linkList.display();

        linkList.insertEnd(40);
        linkList.insertEnd(50);
        linkList.insertEnd(60);

        linkList.display();

        linkList.delete(50);

        linkList.display();
    }

    private static void doubleLinkTest(){
        DoubleLinkList linkList = new DoubleLinkList();
        linkList.insertFirst(10);
        linkList.insertFirst(20);
        linkList.insertFirst(30);

        linkList.display();

        linkList.insertEnd(40);
        linkList.insertEnd(50);
        linkList.insertEnd(60);

        linkList.display();

        linkList.delete(50);

        linkList.display();
    }

}
