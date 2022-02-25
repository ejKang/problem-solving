package com.ps.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        int rst = dp(nums, target, nums.length - 1, map);
        return rst;
    }

    private int dp(int[] nums, int target, int idx, Map<String, Integer> map) {

        if (idx == -1 && target == 0) {
            return 1;
        } else if (idx == -1) {
            return 0;
        }

        if (map.containsKey(idx + "/" + target)) {
            return map.get(idx + "/" + target);
        }

        int add = dp(nums, target + nums[idx], idx - 1, map);
        int sub = dp(nums, target - nums[idx], idx - 1, map);

        map.put(idx + "/" + target, add + sub);

        return add + sub;
    }
}
