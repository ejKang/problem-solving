package com.ps.dp;

public class Tribonacci_1137 {

    public int tribonacci(int n) {

        if (n < 3) {
            if (n == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int[] rst = new int[n + 1];
        rst[0] = 0;
        rst[1] = 1;
        rst[2] = 1;

        for (int i = 3; i <= n; i++) {
            rst[i] = rst[i - 1] + rst[i - 2] + rst[i - 3];
        }
        return rst[n];
    }
}
