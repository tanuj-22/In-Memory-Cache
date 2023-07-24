package com.project;

import com.project.evictionMethods.EvictionPolicy;
import com.project.evictionMethods.LFUEviction;
import com.project.evictionMethods.LRUEviction;
import com.project.store.Storage;
import com.project.store.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LFUCacheTest {
    Cache<Integer,Integer> cache;
    EvictionPolicy<Integer> lfu;
    Storage<Integer, Integer> store;
    @BeforeEach
    public void setup(){
        int capacity = 2;
        lfu = new LFUEviction<>();
        store = new Table<>(capacity);
        cache = new Cache<>(lfu,store,capacity);
    }


    @Test
    public void checkTestCase(){

        assertDoesNotThrow(()->{
            cache.put(1,1);
            cache.put(2,2);
            assertEquals(1,cache.get(1));
            cache.put(3,3);
            assertNull(cache.get(2));
            assertEquals(3,cache.get(3));
            cache.put(4,4);
            assertNull(cache.get(1));
            assertEquals(3,cache.get(3));
            assertEquals(4,cache.get(4));

        });


    }

}
