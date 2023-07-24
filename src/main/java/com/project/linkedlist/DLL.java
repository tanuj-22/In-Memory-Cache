package com.project.linkedlist;

public class DLL<Key> {

    private final Node<Key> head;
    private final Node<Key> tail;
    private int size;


    public DLL(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.setNext(tail);
        tail.setPrev(head);
        this.size = 0;
    }

    public void addFront(Node<Key> x){
        x.setPrev(head);
        Node<Key> prevNext = head.getNext();
        head.setNext(x);
        x.setNext(prevNext);
        prevNext.setPrev(x);
        this.size++;
    }

    public void addLast(Node<Key> x){
        Node<Key> prevLast = tail.getPrev();
        prevLast.setNext(x);
        x.setPrev(prevLast);
        tail.setPrev(x);
        this.size++;
    }

    public void add(Node<Key> x){
        addFront(x);
    }

    public void detachNode(Node<Key> x){

        if(size == 0){
            throw new RuntimeException("CANNOT REMOVE FROM EMPTY LIST");
        }

        Node<Key> prevNode = x.getPrev();
        Node<Key> nextNode = x.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
    }


    public void update(Node<Key> x){

        detachNode(x);
        add(x);
    }

    public Node<Key> getFront(){
        return head.getNext();
    }
    public Node<Key> getLast(){
        return tail.getPrev();
    }

    public int size(){
        return size;
    }

}
