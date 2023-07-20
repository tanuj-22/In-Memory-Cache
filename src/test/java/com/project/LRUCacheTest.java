package com.project;

import com.project.evictionMethods.EvictionPolicy;
import com.project.evictionMethods.LRUEviction;
import com.project.store.Storage;
import com.project.store.Table;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LRUCacheTest {
    Cache cache;
    @BeforeEach
    public void setup(){
        EvictionPolicy lru = new LRUEviction();
        Storage map = new Table();
        int size = 2;
        cache = new Cache(lru,map,2);
    }

    @Test
    public void checkTestCase(){

        assertDoesNotThrow(()->{
            cache.put(1,1);
            cache.put(2,2);
            assertEquals(1,cache.get(1));
            cache.put(3,3);
            assertEquals(-1,cache.get(2));
            cache.put(4,4);
            assertEquals(-1,cache.get(1));
            assertEquals(3,cache.get(3));
            assertEquals(4,cache.get(4));

        });


    }




}
