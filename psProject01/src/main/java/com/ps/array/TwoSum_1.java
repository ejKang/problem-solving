package com.ps.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

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
}
