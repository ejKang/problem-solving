package com.ps.array;

import java.util.Arrays;

public class ThreeSumSmaller_259 {

    public static void main(String[] args) {
        int[] arr = { -2, 0, 1, 3 };
        ThreeSumSmaller_259 aa = new ThreeSumSmaller_259();
        System.out.println(aa.threeSumSmaller(arr, 2));
    }

    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        int rst = 0;
        int j, k;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;

            while (k > j) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    rst += k - j; // !!
                    j++;
                } else {
                    k--;
                }
            }
        }
        return rst;
    }
}
