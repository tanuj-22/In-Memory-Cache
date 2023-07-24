package com.project;

import com.project.config.AppConfig;
import com.project.evictionMethods.EvictionPolicy;
import com.project.evictionMethods.LFUEviction;
import com.project.store.Storage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
            EvictionPolicy<Integer> lfu = context.getBean(EvictionPolicy.class);
            Storage<Integer,Integer> store = context.getBean(Storage.class,2);

            Cache<Integer,Integer> cache = context.getBean(Cache.class,10);

            lfu.keyAccessed(1);
            lfu.keyAccessed(2);
            System.out.println(lfu.evict());
            System.out.println(lfu.evict());
            System.out.println(lfu.getClass());
            System.out.println(cache.capacity);
        }
    }
}
