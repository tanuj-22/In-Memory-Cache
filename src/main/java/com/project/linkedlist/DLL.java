package com.project.linkedlist;

public class DLL {

    private final Node head,tail;
    private int size;

    public int getSize() {
        return size;
    }

    public DLL(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.setNext(tail);
        tail.setPrev(head);
        this.size = 0;
    }

    public void addFront(Node x){
        x.setPrev(head);
        Node prevNext = head.getNext();
        head.setNext(x);
        x.setNext(prevNext);
        prevNext.setPrev(x);
        this.size++;
    }

    public void addLast(Node x){
        Node prevLast = tail.getPrev();
        prevLast.setNext(x);
        x.setPrev(prevLast);
        tail.setPrev(x);
        this.size++;
    }

    public void add(Node x){
        addFront(x);
    }

    public Node removeLast(){

        if(size == 0) return null;


        Node elementToBeRemoved = tail.getPrev();
        Node prevElement = elementToBeRemoved.getPrev();

        prevElement.setNext(tail);
        tail.setPrev(prevElement);
        size--;
        return elementToBeRemoved;

    }

    public void remove(Node x){

        if(size == 0){
            // to be replaced with exception
            return;
        }

        if(x == null) {
            Node node = removeLast();
            return;
        }

        Node prevNode = x.getPrev();
        Node nextNode = x.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        size--;
    }


    public void update(Node x){

        remove(x);
        add(x);

    }

    public Node getFront(){
        return head.getNext();
    }

}
