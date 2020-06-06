package com.example.studyproject.arithmetic.bean;

import java.io.Serializable;

public class Node implements Serializable {

    public int data;//存放数据
    public Node next;//存放下一个节点
    public Node previous;//存放上一个节点

    public Node(int data) {
        this.data = data;
    }
}
