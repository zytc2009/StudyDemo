package com.example.studyproject.arithmetic.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双向链表
 */
public class DoubleLinkList {

    public Node head;
    public Node last;

    public int size;

    public DoubleLinkList() {
        head = new Node(-1);// 实例化头节点
        last = null;
    }

    /**
     * 头插法
     * */
    public void insertFirst(int value){
        Node node = new Node(value);

        if (size == 0){
            last = node;
            head.next = node;
            node.previous = head;

        }else{
            head.next.previous = node;
            node.next = head.next;
            node.previous = head;
            head.next = node;
        }


        size++;
    }

    /**
     * 尾插法
     * */
    public void insertEnd(int value){
        Node node = new Node(value);

        if (size == 0){
            last = node;
            head.next = node;
            node.previous = head;
        }else{
            last.next = node;
            node.previous = last;
            last = node;
        }

        size++;

    }

    /**
     * 遍历链表
     * */
    public void display(){
        Node current = head.next;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 删除节点
     * */
    public Node delete(int value){

        Node current = head.next;
        Node pre = head;
        while (current != null){

            if (current.data == value){

                pre.next = current.next;
                current.next.previous = pre;

                size--;
                return current;
            }
            pre = current;
            current = current.next;
        }


        return null;
    }

    /**
     * 删除头节点
     * */
    public Node deleteHead(){
        if (head.next == null){
            return null;
        }

        Node delete = head.next;

        head.next = head.next.next;
        head.next.previous = head;

        size--;

        return delete;
    }

    /**
     * 删除尾节点
     * */
    public Node deleteLast(){

        if (last == null){
            return null;
        }

        Node delete = last;

        last.previous.next = null;
        last.previous = null;

        size-- ;

        return delete;
    }
}
