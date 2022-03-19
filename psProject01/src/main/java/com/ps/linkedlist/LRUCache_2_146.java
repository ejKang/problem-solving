package com.ps.linkedlist;

import java.util.HashMap;

import com.ps.base.DoubleList;
import com.ps.base.LRUNode;

public class LRUCache_2_146 {

    int capacity;
    HashMap<Integer, LRUNode> map;
    DoubleList cache;

    public LRUCache_2_146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        makeRecentlyUse(key);
        return map.get(key).value;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            makeRecentlyUse(key);
        }

        if (capacity == cache.getSize()) {
            removeLeaseRecently();
        }

        addRecently(key, value);
    }

    private void addRecently(int key, int value) {
        LRUNode node = new LRUNode(key, value);
        map.put(key, node);
        cache.addLast(node);
    }

    private void removeLeaseRecently() {
        LRUNode node = cache.removeFirst();
        int key = node.key;
        map.remove(key);
    }

    private void makeRecentlyUse(int key) {
        LRUNode node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }
}
