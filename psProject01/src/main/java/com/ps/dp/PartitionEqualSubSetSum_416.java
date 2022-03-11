package com.ps.dp;

import java.util.Arrays;

public class PartitionEqualSubSetSum_416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 == 1) {
            return false; // odd case
        }

        sum /= 2;
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 1; j--) {

                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

    public boolean canPartition_2(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 == 1) {
            return false; // odd case
        }

        sum /= 2;

        return subsetSum(nums, 0, 0, sum);
    }

    private boolean subsetSum(int[] nums, int i, int tmpSum, int target) {

        if (tmpSum == target) {
            return true;
        }

        if (i == nums.length || tmpSum > target) {
            return false;
        }

        boolean rst = subsetSum(nums, i + 1, tmpSum + nums[i], target) || subsetSum(nums, i + 1, tmpSum, target);
        return rst;
    }

    public boolean canPartition_3(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 == 1) {
            return false; // odd case
        }

        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) { // selected nums count == 0
                    dp[i][j] = false;
                } else if (j == 0 || dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }

            }
        }
        return dp[nums.length][sum];
    }

    public boolean canPartition_4(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;

        // boolean[] arr = new boolean[sum + 1];
        // arr[0] = true;

        // for (int i = 0; i < nums.length; i++) {
        // for (int j = sum; j > 0; j--) {

        // if (j - nums[i] >= 0) {
        // arr[j] = arr[j] || arr[j - nums[i]];
        // }
        // }
        // }

        // return arr[sum];

        boolean rst = dp_4(nums, sum, 0, 0);
        System.out.println(rst);
        // return rst;
        int numLen = nums.length;
        boolean[][] arr = new boolean[numLen + 1][sum + 1];

        for (int i = 0; i <= numLen; i++) {

            for (int j = 0; j <= sum; j++) {

                if (i == 0 && j == 0) {
                    arr[i][j] = true;
                } else if (i == 0) {
                    arr[i][j] = false;
                } else if (j == 0 || arr[i - 1][j]) {
                    arr[i][j] = true;
                } else {
                    if (j >= nums[i]) {
                        arr[i][j] = arr[i - 1][j] || arr[i - 1][j - nums[i]];
                    }
                }
            }
        }

        return arr[numLen][sum];
    }

    private boolean dp_4(int[] nums, int sum, int i, int tmpSum) {

        if (tmpSum == sum) {
            return true;
        }
        if (i == nums.length || tmpSum > sum) {
            return false;
        }

        boolean rst = dp_4(nums, sum, i + 1, tmpSum + nums[i]) || dp_4(nums, sum, i + 1, tmpSum);
        return rst;
    }
}
