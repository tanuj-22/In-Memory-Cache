package com.project.evictionMethods;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
//        create Object of LFUEviction class with Integer as the data type
//        based on the EvictionPolicyFactory and KeyDataTypeFactory

        EvictionPolicy<Integer> lfu = EvictionPolicyFactory.getEvictionPolicy(LFUEviction.class);
        lfu.keyAccessed(1);
        lfu.keyAccessed(2);
        System.out.println(lfu.evict());
        System.out.println(lfu.evict());
        System.out.println(lfu.getClass());
    }


}
