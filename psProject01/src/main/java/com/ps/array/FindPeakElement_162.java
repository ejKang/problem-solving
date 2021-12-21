package com.ps.array;

public class FindPeakElement_162 {

    // time complex - o(logN) binary search
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (right > left) {
            int pivot = (left + right) / 2;
            if (nums[pivot] < nums[pivot + 1]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }
        return right;
    }
}
