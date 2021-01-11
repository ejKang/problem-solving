package com.ps.twopointer;

public class RemoveDuplicate {
    
    public int removeDuplicates(int[] nums) {
        
        // [1,1,1,2,2,3,6,6,6]

        int i = 0;
        for (int n : nums) {
            if (i < 1 || nums[i-2] < n ) {
                nums[i++] = n;
            }
        }

        return i;
    }
}
