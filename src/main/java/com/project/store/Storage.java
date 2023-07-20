package com.project.store;

import com.project.linkedlist.Node;

public interface Storage<U,T> {

    public boolean isPresent(U key);
    public int size();
    public T get(U key);
    public void put(U key, T value);
    public void remove(U key);

}
