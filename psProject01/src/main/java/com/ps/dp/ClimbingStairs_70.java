package com.ps.dp;

public class ClimbingStairs_70 {

    public int climbStairs(int n) { // bottom-up

        if (n < 2) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public int climbStairs_recur_parent(int n) { // top-down

        if (n <= 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        int rst = climbStairs_recur(n, arr);

        return rst;
    }

    public int climbStairs_recur(int n, int[] array) {

        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        }

        if (array[n] != 0) {
            return array[n];
        } else {
            int n1 = climbStairs_recur(n - 1, array);
            int n2 = climbStairs_recur(n - 2, array);
            array[n - 1] = n1;
            array[n - 2] = n2;
            return n1 + n2;
        }

    }
}
