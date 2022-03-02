package com.ps.dp;

public class MinCostClimbingStairs_746 {

    public static void main(String[] args) {
        MinCostClimbingStairs_746 m = new MinCostClimbingStairs_746();
        int[] a = { 10, 15, 20 };
        m.minCostClimbingStairs(a);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] sumArr = new int[cost.length];

        sumArr[0] = cost[0];
        sumArr[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            sumArr[i] = cost[i] + Math.min(sumArr[i - 1], sumArr[i - 2]);
        }

        return Math.min(sumArr[cost.length - 1], sumArr[cost.length - 2]);
    }
}
