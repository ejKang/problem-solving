package com.ps.array;

import java.util.Arrays;

public class FindPivotIndex_724 {

    // sliding window - o(n)
    public int pivotIndex(int[] nums) {

        int totalSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int pivot = 0;

        for (int i = 0; i < nums.length; i++) {

            pivot = i;
            totalSum -= nums[i];

            if (totalSum == leftSum) {
                return pivot;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
