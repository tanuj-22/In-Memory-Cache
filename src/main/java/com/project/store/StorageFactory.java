package com.project.store;

public class StorageFactory {

    public static <K,V,T> Storage<K,V> getStorage(Class<T> storageClass, int capacity){
        if(storageClass == Table.class){
            return new Table<>(capacity);
        }
        return null;
    }
}
