package com.project.linkedlist;

public class Node<Key> {

    private Node<Key> prev, next;
    private final Key key;

    public Node(Key key){
        this.key = key;
    }

    protected Node<Key> getPrev() {
        return prev;
    }

    protected void setPrev(Node<Key> prev) {
        this.prev = prev;
    }

    protected Node<Key> getNext() {
        return next;
    }

    protected void setNext(Node<Key> next) {
        this.next = next;
    }

    public Key getKey() {
        return key;
    }



}
