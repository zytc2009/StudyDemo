package com.example.studyproject.arithmetic.bean;

/**
 * 单向链表
 */
public class SingleLinkList {

    public Node head;

    public int size;

    public SingleLinkList() {
        head = new Node(-1);// 实例化头节点
    }

    /**
     * 头插法
     * */
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head.next;
        head.next = node;

        size++;
    }

    /**
     * 尾插法
     * */
    public void insertEnd(int value){
        Node node = new Node(value);

        Node current = head.next;
        Node pre = head;
        while (current != null){
            pre = current;
            current = current.next;
        }

        pre.next = node;

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
        Node preNode = head;
        while (current != null){
            if (current.data == value){
                preNode.next = current.next;
                return current;
            }
            preNode = current;
            current = current.next;
        }
        return null;
    }


}
