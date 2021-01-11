package com.ps.twopointer;

public class SortColor {
    
    public void sortColors(int[] nums) {
        // [1, 0, 2, 0, 2, 0]   
        int low = 0, heigh = nums.length -1;

        int i = 0;
        while (i <= heigh) {
            if (nums[i] == 0) {
                nums[i] = nums[low];
                nums[low] = 0;
                low++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[heigh];
                nums[heigh] = 2;
                heigh--;
            } else {
                i++;
            }
        }
    }
}
