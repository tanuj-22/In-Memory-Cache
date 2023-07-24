package com.project.evictionMethods;

import com.project.linkedlist.DLL;
import com.project.linkedlist.Node;
import java.util.HashMap;
import java.util.Map;

public class LRUEviction<Key> implements EvictionPolicy<Key> {

    private final DLL<Key> list;
    private final Map<Key,Node<Key>> keyNodeMap;

    public LRUEviction(){
        this.list = new DLL<>();
        this.keyNodeMap = new HashMap<>();
    }


    @Override
    public Key evict() {

        Node<Key> evictedNode = list.getLast();
        list.detachNode(evictedNode);
        return evictedNode.getKey();

    }

    @Override
    public void keyAccessed(Key key) {

        if(keyNodeMap.containsKey(key)){

            Node<Key> fetchedNode = keyNodeMap.get(key);
            list.update(fetchedNode);

        }
        else{
            Node<Key> newNode = new Node<>(key);
            keyNodeMap.put(key, newNode);
            list.add(newNode);
        }

    }
}
