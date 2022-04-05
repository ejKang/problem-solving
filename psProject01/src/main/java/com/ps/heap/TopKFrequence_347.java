package com.ps.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequence_347 { // 692, 973
    public static void main(String[] args) {

        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] rst = TopKFrequence_347.topKFrequent(nums, 2);

        for (int i : rst) {
            System.out.print(i + ", ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());

        int[] rst = new int[k];
        for (int i = 0; i < k; i++) {
            rst[i] = queue.poll().getKey();
        }
        return rst;
    }

    // 주어진 k 길이 만큼만 오름차순 queue를 구성하도록, queue의 길이가 k보다 길어지면 poll 하여
    // 마지막에는 k개의 요소만 남으므로 해당 값들을 배열로 구성해서 리턴
    public static int[] topKFrequent_min(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            queue.add(m);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] rst = new int[k];
        for (int i = 0; i < k; i++) {
            rst[i] = queue.poll().getKey();
        }
        return rst;
    }

    public int[] topKFrequent_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)
        // -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);

            if (queue.size() > k) {
                queue.poll();
            }
        }
        // queue.addAll(map.entrySet());

        int[] rst = new int[k];
        for (int i = 0; i < k; i++) {
            rst[i] = queue.poll().getKey();
        }
        return rst;
    }

    public int[] topKFrequent_3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        queue.addAll(map.entrySet());
        int[] rst = new int[k];
        for (int i = 0; i < k; i++) {
            rst[i] = queue.poll().getKey();
        }
        return rst;
    }
}
