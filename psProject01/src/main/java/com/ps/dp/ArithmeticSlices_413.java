package com.ps.dp;

import java.util.Arrays;

public class ArithmeticSlices_413 {

    public int numberOfArithmeticSlices(int[] nums) {

        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dp = new int[len];

        for (int i = 2; i < len; i++) {
            if (nums[i - 2] - nums[i - 1] == nums[i - 1] - nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        return Arrays.stream(dp).sum();
    }

    public int numberOfArithmeticSlices_2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 2; i < len; i++) {
            if (nums[i - 2] - nums[i - 1] == nums[i - 1] - nums[i]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
