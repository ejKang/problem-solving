package com.ps.binarySearch;

public class FindMin {
    
    public int findMin(int[] nums) {

        int min = 0, max = nums.length -1;

        while (min < max) {
            int mid = min + (max - min) /2 ;

            if (nums[mid] < nums[max]) {
                max = mid -1;
            } else {
                min = mid ;
            }
        }

        return max;
    }

}
