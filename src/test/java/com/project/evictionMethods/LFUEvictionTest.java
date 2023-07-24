package com.project.evictionMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUEvictionTest {

    private LFUEviction<Integer> lfu;

    @BeforeEach
    void setup(){
        lfu = new LFUEviction<>();

    }

    @Test
    void testNoKeyToEvictInitially(){
        assertThrows(RuntimeException.class,lfu::evict);
    }

    @Test
    void testKeysAreEvictedInSameOrder(){
        lfu.keyAccessed(1);
        lfu.keyAccessed(2);
        lfu.keyAccessed(3);
        lfu.keyAccessed(4);
        assertEquals(1,lfu.evict());
        assertEquals(2,lfu.evict());
        assertEquals(3,lfu.evict());
        assertEquals(4,lfu.evict());

    }

}