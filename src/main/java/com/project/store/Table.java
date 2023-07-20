package com.project.store;

import com.project.linkedlist.Node;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Table<U,T> implements Storage<U,T> {

    private final HashMap<U, T> map;

    public Table() {
        this.map = new HashMap<>();
    }


    @Override
    public boolean isPresent(U key) {
        return map.containsKey(key);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public T get(U key) {
        if(!map.containsKey(key)){
            throw new NoSuchElementException("Table does not contain the key provided");
        }
        return map.get(key);

    }

    @Override
    public void put(U key, T value) {
        map.put(key,value);
    }

    @Override
    public void remove(U key) {
        map.remove(key);
    }
}
