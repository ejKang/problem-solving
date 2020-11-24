package com.ps.twopointer;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {32,4,32,5,667,43,32,0,9,8,0,76,0};
        
        if (nums == null || nums.length == 0 ) return ;

        int position = 0 ;

        for ( int num : nums) {
            if (num != 0) nums[position++] = num;
        }

        while (position < nums.length) {
            nums[position++] = 0;
        }

        System.out.println(Arrays.toString(nums));

    }
}
