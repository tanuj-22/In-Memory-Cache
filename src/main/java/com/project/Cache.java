package com.project;

import com.project.evictionMethods.EvictionPolicy;
import com.project.linkedlist.Node;
import com.project.store.Storage;

public class Cache {

    EvictionPolicy evictionPolicy;
    Storage<Integer,Node> storage;
    int capacity;

    public Cache(EvictionPolicy evictionPolicy,Storage<Integer,Node> storage, int capacity){
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public int get(int key){
        if(!storage.isPresent(key)){
            return -1;
        }

        Node node = storage.get(key);
        evictionPolicy.update(node);
        return node.getValue();
    }

    public void put(int key,int value){

        if(storage.isPresent(key)){
            Node node = storage.get(key);
            storage.remove(key);
            evictionPolicy.evict(node);
        }

        if(storage.size() == capacity){

            Node removedNode = evictionPolicy.evict();
            storage.remove(removedNode.getKey());


        }

        Node newNode = new Node(key,value);
        storage.put(key,newNode);
        evictionPolicy.put(newNode);

    }



}
