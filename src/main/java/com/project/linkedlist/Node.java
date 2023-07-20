package com.project.linkedlist;

public class Node {

    private Node prev, next;
    private Integer key,value;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

}
