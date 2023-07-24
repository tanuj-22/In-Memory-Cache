package com.project.evictionMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LRUEvictionTest {

    private LRUEviction<Integer> lru;

    @BeforeEach
    void setup(){
        lru = new LRUEviction<>();
    }

    @Test
    void testNoKeyToEvictInitially(){
        assertThrows(RuntimeException.class,lru::evict);
    }

    @Test
    void testKeysAreEvictedInSameOrder(){
        lru.keyAccessed(1);
        lru.keyAccessed(2);
        lru.keyAccessed(3);
        lru.keyAccessed(4);
        assertEquals(1,lru.evict());
        assertEquals(2,lru.evict());
        assertEquals(3,lru.evict());
        assertEquals(4,lru.evict());

    }




}
