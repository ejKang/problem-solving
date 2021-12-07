package com.ps.array;

public class BinarySearch_704 {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int pivot = 0;

        while (left <= right) {
            pivot = (left + right) / 2;

            if (target == nums[pivot]) {
                return pivot;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }
}
