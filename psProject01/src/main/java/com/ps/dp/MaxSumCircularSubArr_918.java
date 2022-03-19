package com.ps.dp;

public class MaxSumCircularSubArr_918 {

    public int maxSubarraySumCircular(int[] nums) {

        int curMax = nums[0];
        int curMin = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int sum = nums[0];
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            curMin = Math.min(curMin + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);
            minSum = Math.min(minSum, curMin);
            sum += nums[i];
        }
        // sum == minSum -> only negative elements 
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
