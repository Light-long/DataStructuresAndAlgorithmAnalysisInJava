package com.tx.datastructur.linkedlist;

public class Node {

    // 数据域
    private Integer data;

    // 指针域
    private Node next;

    // 构造方法
    public Node() {

    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    //get and set
    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}
