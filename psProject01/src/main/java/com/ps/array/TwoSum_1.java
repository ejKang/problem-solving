package com.ps.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    // time complexity - o(n)
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[] { i, map.get(t) };
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] twoSum_2(int[] nums, int target) {

        // for (int i = 0; i < nums.length - 1; i++) {
        // int num1 = nums[i];
        // for (int j = i + 1; j < nums.length; j++) {

        // if (target - num1 == nums[j]) {
        // return new int[] { i, j };
        // }
        // }
        // }

        Map<Integer, Integer> map = new HashMap<>();

        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[] { i, map.get(tmp) };
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
} // 15, 259, 16, 18
