package com.ps.slidingWindow;

public class LongestOnes {
    
    public int longestOnes(int[] A, int K) {
        
        int start = 0, end = 0, rst = 0 ;

        for (end = 0; end < A.length; end++) {

            if (A[end] == 0) K--;

            while (K < 0) {
                if (A[start] == 0) K++;
                start++;
            }

            rst = Math.max(rst, end - start + 1);
        }

        return rst;
    }
}
