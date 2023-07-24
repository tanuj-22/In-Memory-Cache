package com.project.store;


public interface Storage<Key,Value> {


     int size();
     void add(Key key, Value value);
     void remove(Key key);
     Value get(Key key);

}
