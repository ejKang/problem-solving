package com.ps.array;

public class MinimumSizeSubArraySum_209 {

    public int minSubArrayLen(int target, int[] nums) {

        int idx = 0;
        int rst = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= target) {
                // make shorter of idx
                rst = Math.min(rst, i - idx + 1);
                sum -= nums[idx];
                idx++;
                while (sum >= target) {
                    rst = Math.min(rst, i - idx + 1);
                    sum -= nums[idx];
                    idx++;
                }
            }
        }
        return rst == Integer.MAX_VALUE ? 0 : rst;
    }
}
