package com.ps.dp;

public class HouseRober_198 {

    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }
        int tmp1 = dp(0, len - 1, nums);
        int tmp2 = dp(1, len - 1, nums);
        Math.max(tmp1, tmp2);

        // solution 2
        int[][] rst2 = new int[len + 1][2];
        int tmp3 = dp2(1, len, nums, rst2, 0);
        int tmp4 = dp2(2, len, nums, rst2, 1);
        return Math.max(tmp3, tmp4);
    }

    private int dp2(int start, int end, int[] nums, int[][] rst2, int idx) {
        rst2[start][idx] = nums[start - 1];

        for (int i = start; i < end; i++) {

            rst2[i + 1][idx] = Math.max(rst2[i][idx], rst2[i - 1][idx] + nums[i]);
        }
        return rst2[end][idx];
    }

    private int dp(int start, int end, int[] nums) {

        int current = 0;
        int previous = 0;

        for (int i = start; i <= end; i++) {
            int tmp = current;
            current = Math.max(current, previous + nums[i]);
            previous = tmp;
        }
        return Math.max(current, previous);
    }

    public int rob_2(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return nums[0];
        }
        int[][] rst = new int[len + 1][2];

        int tmp1 = dynamicProgramming(1, len, nums, rst, 0);
        int tmp2 = dynamicProgramming(2, len, nums, rst, 1);

        return Math.max(tmp1, tmp2);
    }

    private int dynamicProgramming(int start, int end, int[] nums, int[][] rst, int idx) {
        rst[start][idx] = nums[start - 1];

        for (int i = start; i < end; i++) {
            rst[i + 1][idx] = Math.max(rst[i][idx], rst[i - 1][idx] + nums[i]);
        }
        return rst[end][idx];
    }
}
