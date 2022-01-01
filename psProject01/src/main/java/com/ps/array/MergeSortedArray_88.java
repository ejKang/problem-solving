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

    public void merge_2(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;

        int t = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[t--] = nums1[i--];
            } else {
                nums1[t--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[t--] = nums2[j--];
        }
    }
}
