package com.ps.dp;

public class MinCostClimingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] t = new int[len + 1];
        t[0] = cost[0];
        t[1] = cost[1];
        return Math.min(dp(cost, t, len - 1), dp(cost, t, len - 2));

        // int len = cost.length;
        // int[] t = new int[len + 1];
        // t[0] = cost[0];
        // t[1] = cost[1];

        // for (int i = 2; i < len; i++) {
        // t[i] = Math.min(t[i - 1], t[i - 2]) + cost[i];
        // }
        // return Math.min(t[len-1], t[len-2]);
    }

    private int dp(int[] cost, int[] t, int len) {
        if (len == 0) {
            return t[0];
        }
        if (len == 1) {
            return t[1];
        }
        if (t[len] != 0) {
            return t[len];
        }

        int n1 = dp(cost, t, len - 1);
        int n2 = dp(cost, t, len - 2);
        t[len] = Math.min(n1, n2) + cost[len];

        return t[len];
    }

}
