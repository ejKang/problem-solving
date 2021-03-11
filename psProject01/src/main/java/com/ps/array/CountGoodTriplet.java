package com.ps.array;

public class CountGoodTriplet {
    
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        
        int rst = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j < arr.length - 1; j++) {
                
                if (Math.abs(arr[i] - arr[j]) - a > 0) {
                    continue;
                }
                
                for (int k = j + 1; k < arr.length; k++ ) {
                    if (Math.abs(arr[k] - arr[j]) - b > 0) {
                        continue;
                    }

                    if (Math.abs(arr[k] - arr[i]) - c > 0) {
                        continue;
                    }

                    rst++;
                }
            }
        }
        return rst;   
    }
}
