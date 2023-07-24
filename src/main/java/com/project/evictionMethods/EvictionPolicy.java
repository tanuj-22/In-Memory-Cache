package com.project.evictionMethods;

public interface EvictionPolicy<Key> {


    Key evict();
    void keyAccessed(Key key);

}
