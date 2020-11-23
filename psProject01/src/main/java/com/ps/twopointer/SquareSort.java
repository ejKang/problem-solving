package com.ps.twopointer;

import java.util.Arrays;

public class SquareSort {
    public static void main(String[] args) {
        int[] A = {-4,-1,0,3,10};
        System.out.println(SquareSort.sortedSquares(A));
        System.out.println(SquareSort.sortedSquares2(A));
    }

    public static int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length ; i++) {
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }

    public static int[] sortedSquares2(int[] A) {
        int len = A.length;
        int j = 0;

        while(j<len && A[j] < 0) {
            j++;
        }

        int i = j -1;

        int[] ans = new int[len];
        int t = 0;

        while(i >=0 && j < len) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[t++] = A[j] * A[j];
                j++;
            } else {
                ans[t++] = A[i] * A[i];
                i--;
            }
        }

        while (i>=0) {
            ans[t++] = A[i] * A[i];
            i--;
        }

        while (j < len) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }
}
