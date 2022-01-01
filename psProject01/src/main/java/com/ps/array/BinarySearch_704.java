package com.ps.array;

public class BinarySearch_704 {

    // time complex O(logN)
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

    public int search_2(int[] nums, int target) {

        int first = 0;
        int last = nums.length - 1;

        int pivot = 0;
        while (first <= last) { // !! 
            pivot = (first + last) / 2;

            if (nums[pivot] == target) {
                return pivot;
            }

            if (nums[pivot] > target) {
                last = pivot - 1;
            } else {
                first = pivot + 1;
            }
        }

        return -1;
    }

}
