package com.project.store;

import java.util.HashMap;

public class Table<U,T> implements Storage<U,T> {

    private final HashMap<U, T> map;
    private int size;
    private final int capacity;

    private Table(){
        this.capacity = 100;
        this.map = new HashMap<>();
    }

    public Table(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(U key) {
        if(!map.containsKey(key)){
            return null;
        }
        return map.get(key);

    }

    @Override
    public void add(U key, T value) {

        if(size == capacity)  {
            throw new RuntimeException("Capacity is full");
        }

        map.put(key,value);
        size++;
    }

    @Override
    public void remove(U key) {
        map.remove(key);
        size--;
    }

}
