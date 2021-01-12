package com.ps.twopointer;

public class NumSubArrayProduct {
    
    public static void main(String[] args) {
        NumSubArrayProduct s = new NumSubArrayProduct();
        int[] a = {10,5,2,6};
        s.numSubarrayProductLessThanK(a, 100);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            
            int product = nums[i];
            for (int j = i ; j < nums.length; j++) {
                
                if ( i == j && nums[i] < k) {
                    rst++;
                    continue;
                } 

                product *= nums[j];

                if (product < k) rst++;
                else break;
            }
        }
        
        return rst;    
    }

}
