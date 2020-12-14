package com.ps.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargest {
    
    public static void main(String[] args) {
        int [] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(FindKthLargest.findKthLargest(nums, 4));

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
}
