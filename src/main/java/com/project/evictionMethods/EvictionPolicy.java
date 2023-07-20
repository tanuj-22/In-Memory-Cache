package com.project.evictionMethods;

import com.project.linkedlist.Node;

public interface EvictionPolicy {


    Node evict();
    void evict(Node node);

    void put( Node newNode);

    void update(Node node);
}
