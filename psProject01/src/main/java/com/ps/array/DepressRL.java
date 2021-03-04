package com.ps.array;

public class DepressRL {
    
    public static void main(String[] args) {
        DepressRL a = new DepressRL();
        int[] b = {1,2,3,4};
        a.decompressRLElist(b);
    }
    public int[] decompressRLElist(int[] nums) {
        int size = 0;

        for (int i = 0; i<nums.length; i+=2) {
            size += nums[i];
        }

        int[] rst = new int[size];

        int idx = 0;
        for (int i = 0 ; i< nums.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0 ; j < nums[i]; j++) {
                    rst[idx++] = nums[i+1];
                }
            } else {

            }
        }
        return rst;
    }
}
