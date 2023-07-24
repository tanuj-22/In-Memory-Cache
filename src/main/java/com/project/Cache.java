package com.project;

import com.project.evictionMethods.EvictionPolicy;
import com.project.store.Storage;

public class Cache<K,V> {

    EvictionPolicy<K> evictionPolicy;
    Storage<K,V> storage;
    int capacity;

    public Cache(EvictionPolicy<K> evictionPolicy,Storage<K,V> storage, int capacity){
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public V get(K key){

        V value = storage.get(key);
        if(value == null) return null;

        evictionPolicy.keyAccessed(key);
        return storage.get(key);
    }

    public void put(K key,V value){

        if(storage.get(key) != null){
            storage.remove(key);
        }

        if(storage.size() == capacity){

            K keyToBeRemoved = evictionPolicy.evict();
            storage.remove(keyToBeRemoved);

        }

        storage.add(key,value);
        evictionPolicy.keyAccessed(key);

    }



}
