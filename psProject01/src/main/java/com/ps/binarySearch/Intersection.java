package com.ps.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();

        for (int i : nums2) {
            if (binarySearchIsExist(i, nums1 )) {
                list.add(i);
            }
        }

        int[] rst = new int[list.size()];
        int c = 0;
        for (Integer i : list) {
            rst[c++] = i;
        }
        
        return rst;   
    }

    private boolean binarySearchIsExist(int i, int[] nums1) {
        int start = 0, end = nums1.length -1 ;

        while ( start <= end) {
            int mid = start + (end - start) / 2; 

            if (nums1[mid] == i) {
                return true;
            }

            if (nums1[mid] > i) {
                end = mid -1 ;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
