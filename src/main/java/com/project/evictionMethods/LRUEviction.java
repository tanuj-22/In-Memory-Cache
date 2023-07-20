package com.project.evictionMethods;

import com.project.linkedlist.DLL;
import com.project.linkedlist.Node;

public class LRUEviction implements EvictionPolicy {

    private final DLL list;

    public LRUEviction(){
        this.list = new DLL();
    }


    @Override
    public Node evict() {

        return list.removeLast();

    }

    @Override
    public void evict(Node node) {
        list.remove(node);
    }

    @Override
    public void put(Node newNode) {
        list.add(newNode);
    }

    @Override
    public void update(Node node) {
        list.update(node);
    }


}
