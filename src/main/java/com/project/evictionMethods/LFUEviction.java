package com.project.evictionMethods;

import com.project.linkedlist.DLL;
import com.project.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

public class LFUEviction<Key> implements EvictionPolicy<Key> {

    private int minFrequency;
    private final Map<Key, Node<Key>> keyNodeMap;
    private final Map<Integer,DLL<Key>> freqListMap;
    private final Map<Key,Integer> keyFreqMap;

    public LFUEviction() {
        this.keyNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
        this.keyFreqMap = new HashMap<>();
        this.minFrequency = 1;
    }


    @Override
    public Key evict() {
        DLL<Key> minFreqList = freqListMap.get(minFrequency);
        Node<Key> toBeRemoved = minFreqList.getLast();
        minFreqList.detachNode(toBeRemoved);
        Key key = toBeRemoved.getKey();
        keyFreqMap.remove(key);
        keyNodeMap.remove(key);

        return key;
    }

    @Override
    public void keyAccessed(Key key) {
        if(keyNodeMap.containsKey(key)){

            Node<Key> currNode = keyNodeMap.get(key);
            int currNodeFreq = keyFreqMap.get(key);
            DLL<Key> currList = freqListMap.get(currNodeFreq);
            currList.detachNode(currNode);

            if(minFrequency == currNodeFreq && currList.size() == 0){
                minFrequency++;
            }

            keyFreqMap.put(key,currNodeFreq+1);

            DLL<Key> newList = freqListMap.getOrDefault(currNodeFreq+1, new DLL<>());
            newList.add(currNode);
            freqListMap.put(currNodeFreq+1,newList);

        }
        else{

            minFrequency = 1;
            Node<Key> newNode = new Node<>(key);
            DLL<Key> minFreqList = freqListMap.getOrDefault(minFrequency,new DLL<>());
            minFreqList.add(newNode);
            freqListMap.put(minFrequency,minFreqList);
            keyNodeMap.put(key,newNode);
            keyFreqMap.put(key,minFrequency);

        }

    }
}
