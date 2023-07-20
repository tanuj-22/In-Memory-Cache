package com.project.evictionMethods;

import com.project.linkedlist.DLL;
import com.project.linkedlist.Node;
import com.project.store.Storage;

public class LFUEviction implements EvictionPolicy {

    Storage<Integer,Node> storage;


    @Override
    public Node evict() {
        return null;
    }

    @Override
    public void evict(Node node) {

    }

    @Override
    public void put(Node newNode) {

    }

    @Override
    public void update(Node node) {

    }
}
