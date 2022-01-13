package com.ps.array;

import java.util.Arrays;

public class ThreeSumCloset_16 {

    public static void main(String[] args) {

        int[] nums = { 1, 1, -1, -1, 3 };
        ThreeSumCloset_16 a = new ThreeSumCloset_16();
        System.out.println(a.threeSumClosest(nums, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int j, k, rst = Integer.MAX_VALUE;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;

            while (k > j) {
                tmp = (nums[i] + nums[j] + nums[k]);

                if (rst == Integer.MAX_VALUE || Math.abs(target - tmp) < Math.abs(target - rst)) {
                    rst = tmp;
                }
                if (tmp > target) {
                    k--;
                } else {
                    j++;
                }

            }
        }
        return rst;
    }

}
