package com.ps.linkedlist;

import java.util.LinkedHashMap;

public class LRUCache_146 {

    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecentlyUse(key);

        return cache.get(key);

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecentlyUse(key);
            return;
        }

        if (cache.size() >= this.capacity) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        cache.put(key, value);
    }

    private void makeRecentlyUse(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
