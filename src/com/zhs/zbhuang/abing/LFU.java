package com.zhs.zbhuang.abing;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class LFU {
    Integer capacity;
    Integer min;
    Map<Integer, Pair<Integer, Integer>> cacheMap;
    Map<Integer, LinkedHashSet<Integer>> frequenciesMap;

    public LFU(Integer capacity) {
        this.capacity = capacity;
        min = 0;
        cacheMap = new HashMap<>();
        frequenciesMap = new HashMap<>();
    }

    void insert(Integer key, Integer frequencies, Integer value) {
        cacheMap.put(key, new Pair<>(frequencies, value));
        frequenciesMap.putIfAbsent(key, new LinkedHashSet<Integer>());
        frequenciesMap.get(frequencies).add(key);
    }

    public Integer get(Integer key) {
        Pair<Integer, Integer> pair = cacheMap.get(key);
        if(null == pair) return -1;
        Integer frequencies = pair.getKey();
        LinkedHashSet<Integer> keys = frequenciesMap.get(frequencies);
        keys.remove(key);
        if(Objects.equals(frequencies, min) && keys.isEmpty()) {
            ++min;
        }
        Integer value = pair.getValue();
        insert(key, frequencies+1, value);
        return value;
    }

    public void put(Integer key, Integer value) {
        if(capacity < 1) return;
        Pair<Integer, Integer> pair = cacheMap.get(key);
        if(null != pair) {
            cacheMap.put(key, new Pair<>(pair.getKey(), value));
            get(key);
            return;
        }
        if(capacity == cacheMap.size()) {
            LinkedHashSet<Integer> keys = frequenciesMap.get(min);
            Integer deleteKey = keys.iterator().next();
            cacheMap.remove(deleteKey);
            keys.remove(deleteKey);
        }
        min = 1;
        insert(key, 1, value);
    }
}
