package com.ps.dp;

public class HouseRober2_213 {

    public int rob(int[] nums) {

        int len = nums.length;

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        int rst1 = Math.max(dp(nums, 0, len - 2), dp(nums, 1, len - 1));
        System.out.println(rst1);

        int[][] store = new int[len + 1][2];
        int rst2 = Math.max(dp2(nums, 1, len - 1, store, 0), dp2(nums, 2, len, store, 1));
        return rst2;
    }

    private int dp(int[] nums, int start, int end) {

        int currnetVisit = 0;
        int nonVisit = 0;

        for (int i = start; i <= end; i++) {
            int tmp = nonVisit;
            nonVisit = Math.max(currnetVisit, nonVisit);
            currnetVisit = nums[i] + tmp;
        }
        return Math.max(currnetVisit, nonVisit);
    }

    private int dp2(int[] nums, int start, int end, int[][] store, int current) {
        store[start][current] = nums[start - 1];

        for (int i = start; i < end; i++) {
            store[i + 1][current] = Math.max(store[i][current], store[i - 1][current] + nums[i]);
        }
        return store[end][current];
    }
}
