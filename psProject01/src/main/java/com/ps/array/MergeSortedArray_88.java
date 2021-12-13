package com.ps.array;

public class MergeSortedArray_88 {

    // time complex O(M + N)
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1Idx = m - 1;
        int nums2Idx = n - 1;

        int point = nums1.length - 1;

        while (nums1Idx >= 0 && nums2Idx >= 0) {

            if (nums1[nums1Idx] >= nums2[nums2Idx]) {
                nums1[point] = nums1[nums1Idx];
                point--;
                nums1Idx--;
            } else {
                nums1[point] = nums2[nums2Idx];
                point--;
                nums2Idx--;
            }
        }

        if (nums2Idx >= 0) {
            while (nums2Idx >= 0) {
                nums1[point] = nums2[nums2Idx];
                point--;
                nums2Idx--;
            }
        }

    }
}
