package com.project.config;

import com.project.Cache;
import com.project.evictionMethods.EvictionPolicy;
import com.project.evictionMethods.EvictionPolicyFactory;
import com.project.evictionMethods.LFUEviction;
import com.project.evictionMethods.LRUEviction;
import com.project.store.Storage;
import com.project.store.StorageFactory;
import com.project.store.Table;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    int capacity = 2;

    @Bean("lfuEvictionPolicy")
    @Primary
    public <K>EvictionPolicy<K> lfuEvictionPolicy(){
        return EvictionPolicyFactory.getEvictionPolicy(LFUEviction.class);
    }

    @Bean("lruEvictionPolicy")
    public <K>EvictionPolicy<K> lruEvictionPolicy(){
        return EvictionPolicyFactory.getEvictionPolicy(LRUEviction.class);
    }

    @Bean("storage")
    @Scope("prototype")
    @Primary
    public <K,V> Storage<K,V> tableStorage(int capacity){
        return StorageFactory.getStorage(Table.class,capacity);
    }

    @Bean("cache")
    public <K,V> Cache<K,V> cache(){
        return new Cache<>(lfuEvictionPolicy(),tableStorage(capacity),capacity);
    }





}
