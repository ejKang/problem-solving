package com.ps.dp;

public class JumpGame2_45 {

    public int jump(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int steps = 0;
        int max = 0;
        int cur_limit = 0;

        for (int i = 0; i < len - 1; i++) {
            if (i == 0) {
                max = nums[i];
                cur_limit = nums[i];
                steps++;
            } else {
                max = Math.max(max, i + nums[i]);
                if (i == cur_limit) {
                    steps++;
                    cur_limit = max;
                }
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int max = nums[0];
        int cur_limit = nums[0];
        int cnt = 1;
        for (int i = 1; i <= len - 2; i++) {
            max = Math.max(max, i + nums[i]);

            if (max == len - 1) {
                return cnt;
            }
            if (i == cur_limit) {
                cnt++;
                cur_limit = max;
            }
        }
        return cnt;
    }
}
