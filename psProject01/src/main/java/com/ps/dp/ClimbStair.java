package com.ps.dp;

public class ClimbStair {

    public static void main(String[] args) {
        ClimbStair cs = new ClimbStair();
        System.out.println(cs.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] t = new int[n + 1];
        t[0] = 1;
        t[1] = 1;
        int rst = df(n, t);

        return rst;

        // int[] t = new int[n];
        // t[0] = 1;
        // t[1] = 1;
        // for (int i=2; i<n; i++) {
        // t[i] = t[i-1] + t[i-2];
        // }
        // return t[n-1];
    }

    private int df(int n, int[] t) {

        if (n == 1) {
            return 1;
        }

        if (n == 0) {
            return 1;
        }

        if (t[n] != 0) {
            return t[n];
        }
        int n1 = df(n - 1, t);
        int n2 = df(n - 2, t);
        t[n] = n2 + n1;
        return n1 + n2;
    }
}
