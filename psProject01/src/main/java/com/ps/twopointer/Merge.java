package com.ps.twopointer;

public class Merge {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m -1 , j = n -1;
        int total = n + m -1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] >= nums2[j]) {
                nums1[total--] = nums1[i--] ; 
            } else {
                nums1[total--] = nums2[j--] ; 
            }
        }

        while (j >= 0) {
            nums1[total--] = nums2[j--] ; 
        }
    }
}
