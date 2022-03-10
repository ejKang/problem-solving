package com.ps.dp;

public class FibonacciNum_509 {

    public int fib(int n) {

        if (n < 2) {
            return n;
        }

        int[] rst = new int[n + 1];
        rst[0] = 0;
        rst[1] = 1;

        for (int i = 2; i <= n; i++) {
            rst[i] = rst[i - 1] + rst[i - 2];
        }
        return rst[n];
    }
}
