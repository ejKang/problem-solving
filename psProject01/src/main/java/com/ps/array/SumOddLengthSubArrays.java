package com.ps.array;

public class SumOddLengthSubArrays {
    
    public int sumOddLengthSubarrays(int[] arr) {
        
        int rst = 0;
        for (int i=0; i< arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                if (i == j) {
                    rst += arr[i];
                } else {

                    if ((j - i) % 2 == 0) { // odd length case

                        for (int k = i ; k <= j; k++) {
                            rst += arr[k];
                        }
                    }
                }
            }
        }
        return rst;
    }
}
