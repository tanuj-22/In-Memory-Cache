package com.project.evictionMethods;

public class EvictionPolicyFactory {

    public static <Key,T> EvictionPolicy<Key> getEvictionPolicy(Class<T> evictionPolicyClass){

        if(evictionPolicyClass.equals(LFUEviction.class)){
            return new LFUEviction<>();
        }
        else if(evictionPolicyClass.equals(LRUEviction.class)){
            return new LRUEviction<>();
        }
        else{
            return null;
        }

    }
}
