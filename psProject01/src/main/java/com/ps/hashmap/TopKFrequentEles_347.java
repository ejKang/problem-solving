package com.ps.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// related topic : heap
public class TopKFrequentEles_347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = map.entrySet().stream().sorted((a, b) -> {
            return b.getValue() - a.getValue();
        }).map(m -> m.getKey()).limit(k).collect(Collectors.toList());

        int[] rst = new int[k];
        int t = 0;
        for (int i : list) {
            rst[t] = i;
            t++;
        }

        return rst;
    }
}
