package com.ps.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(FrequencySort.frequencySort("teeb"));   
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            for(int i = 0; i<e.getValue(); i++ ) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}