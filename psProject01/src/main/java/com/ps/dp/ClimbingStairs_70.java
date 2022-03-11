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

    public int climbStairs_2_bottom_up(int n) {

        if (n <= 1) {
            return n;
        }
        int[] rst = new int[n];
        rst[0] = 1;
        rst[1] = 2;

        for (int i = 2; i < n; i++) {
            rst[i] = rst[i - 1] + rst[i - 2];
        }
        return rst[n - 1];
    }

    public int climbStairs_2_top_down(int n) {
        int[] rst = new int[n + 1];
        rst[1] = 1;
        rst[2] = 2;

        return dp(rst, n);
    }

    private int dp(int[] rst, int n) {
        if (rst[n] > 0) {
            return rst[n];
        }

        rst[n - 1] = dp(rst, n - 1);
        rst[n - 2] = dp(rst, n - 2);

        return rst[n - 1] + rst[n - 2];
    }

    public int climbStairs_3_bottom_up(int n) {
        if (n <= 2) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
