package com.ps.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargest_215 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(FindKthLargest_215.findKthLargest(nums, 4));

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {
            queue.add(i);
        }

        int rst = 0;
        while (k != 0) {
            rst = queue.poll();
            k--;
        }
        return rst;
    }

    public static int findKthLargest_size(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : nums) {
            queue.add(i);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int rst = queue.poll();
        return rst;
    }
}
