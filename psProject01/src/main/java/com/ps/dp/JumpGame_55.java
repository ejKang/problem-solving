package com.ps.dp;

public class JumpGame_55 {

    public static void main(String[] args) {
        JumpGame_55 j = new JumpGame_55();
        int[] nums = { 1, 1, 0, 1 };
        j.canJump(nums);
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i <= max; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = Math.max(i + nums[i], dp[i - 1]);
            }
            max = Math.max(max, dp[i]);
            if (dp[i] >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return true;
        }

        int max = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i <= max; i++) {
            dp[i] = Math.max(max, i + nums[i]);
            max = Math.max(max, dp[i]);

            if (max >= len - 1) {
                return true;
            }
        }
        return false;
    }

}
