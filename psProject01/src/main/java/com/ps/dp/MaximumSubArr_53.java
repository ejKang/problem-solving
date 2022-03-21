package com.ps.dp;

public class MaximumSubArr_53 {

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        int startIdx = 0, endIdx = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (sum > max) {
                endIdx = i;
            }
            max = Math.max(sum, max);

            if (sum < 0) {
                startIdx = i + 1;
                sum = 0;
            }
        }

        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(nums[i] + ", ");
        }

        return max;
    }
}
