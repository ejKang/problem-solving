package com.ps.array;

public class ShortestUnSortedContinuousSubArray_581 {

    public int findUnsortedSubarray(int[] nums) {

        boolean found = false;
        int min = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length - 1; i++) {

            if (!found) {
                //
                if (nums[i] < nums[i - 1]) {
                    found = true;
                    min = nums[i];
                }
            } else {
                // find minimum
                if (min >= nums[i]) {
                    min = nums[i];
                }
            }
        }

        int l = 0;
        if (!found) {
            return 0;
        } else {
            // find start index

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > min) {
                    break;
                }
                l++;
            }
        }

        found = false;
        int max = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (!found) {
                if (nums[i] > nums[i + 1]) {
                    found = true;
                    max = nums[i];
                }
            } else {
                if (max <= nums[i]) {
                    max = nums[i];
                }
            }
        }
        int h = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                break;
            }
            h--;
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("l = " + l);
        System.out.println("h = " + h);
        return h - l + 1;
    }
}
