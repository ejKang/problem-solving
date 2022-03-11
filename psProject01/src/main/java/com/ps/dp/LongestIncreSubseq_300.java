package com.ps.dp;

import java.util.Arrays;

public class LongestIncreSubseq_300 {

    // time complexity - o(n^2)
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

    // time complexity - o(nlogn)
    public int lengthOfLIS_DP_BS(int[] nums) {
        int len = nums.length;
        int cursor = 1;
        int[] dp = new int[len];

        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[cursor - 1]) {
                dp[cursor++] = nums[i];
            } else {
                int idx = findLocationUsingBinarySearch(dp, 0, cursor - 1, nums[i]);
                dp[idx] = nums[i];
            }
        }
        return cursor;
    }

    private int findLocationUsingBinarySearch(int[] dp, int low, int high, int target) {

        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int lengthOfLIS_2(int[] nums) {
        int len = nums.length;
        int[] rst = new int[len];

        Arrays.fill(rst, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    rst[i] = Math.max(rst[i - 1], rst[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : rst) {
            max = Math.max(max, i);
        }
        return max;
    }
}
