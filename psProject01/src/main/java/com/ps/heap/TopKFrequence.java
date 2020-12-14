package com.ps.heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequence {
    
    public static void main(String[] args) {
        
        int [] nums = {1,1,1,2,2,3};
        int [] rst = TopKFrequence.topKFrequent(nums, 2);

        for (int i : rst) {
            System.out.print(i + ", ");
        }
        
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> keyset = new HashSet<>();
        for (int i :nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
            keyset.add(i);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        queue.addAll(map.entrySet());

        int[] rst = new int[k];
        for (int i = 0 ; i< k; i++) {
            rst[i] = queue.poll().getKey();
        }
        return rst;
    }
}
