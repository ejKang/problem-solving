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

    public int rob_2(int[] nums) {

        int len = nums.length;

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        int rst = Math.max(dp_2(nums, 0, len - 2), dp_2(nums, 1, len - 1));
        System.out.println(rst);

        int[][] store = new int[len + 1][2];
        int rst_2 = Math.max(dp_22(nums, 1, len - 1, store, 0), dp_22(nums, 2, len, store, 1));
        // return rst;
        return rst_2;
    }

    private int dp_22(int[] nums, int start, int end, int[][] store, int cur) {
        store[start][cur] = nums[start - 1];

        for (int i = start; i <= end; i++) {
            store[i + 1][cur] = Math.max(store[i][cur], store[i - 1][cur] + nums[i]);
        }

        return store[end][cur];
    }

    private int dp_2(int[] nums, int start, int end) {

        int curVisit = 0;
        int nonVisit = 0;

        for (int i = start; i <= end; i++) {
            int tmp = nonVisit;
            nonVisit = Math.max(curVisit, nonVisit);
            curVisit = tmp + nums[i];
        }
        return Math.max(curVisit, nonVisit);
    }

    public int rob_3(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }
        int tmp1 = dp_3(0, len - 2, nums);
        int tmp2 = dp_3(1, len - 1, nums);
        Math.max(tmp1, tmp2);

        // solution 2
        int[][] rst2 = new int[len + 1][2];
        int tmp3 = dp_32(1, len - 1, nums, rst2, 0);
        int tmp4 = dp_32(2, len, nums, rst2, 1);
        return Math.max(tmp3, tmp4);
    }

    private int dp_32(int start, int end, int[] nums, int[][] rst2, int idx) {
        rst2[start][idx] = nums[start - 1];
        for (int i = start; i < end; i++) {
            rst2[i + 1][idx] = Math.max(rst2[i - 1][idx] + nums[i], rst2[i][idx]);
        }
        return rst2[end][idx];
    }

    private int dp_3(int start, int end, int[] nums) {

        int current = 0;
        int previous = 0;

        for (int i = start; i <= end; i++) {
            int tmp = current;
            current = Math.max(current, previous + nums[i]);
            previous = tmp;
        }
        return Math.max(current, previous);
    }
}
