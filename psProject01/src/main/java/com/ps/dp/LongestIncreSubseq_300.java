package com.ps.dp;

import java.util.Arrays;

public class LongestIncreSubseq_300 {

    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
