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

    public int minCostClimbingStairs_2_bottom_up(int[] cost) {

        int len = cost.length;
        int[] rst = new int[len];

        rst[0] = cost[0];
        rst[1] = cost[1];

        for (int i = 2; i < len; i++) {
            int tmp = Math.min(rst[i - 1], rst[i - 2]);
            rst[i] = cost[i] + tmp;
        }

        int t = Math.min(rst[len - 1], rst[len - 2]);
        return t;
    }

    public int minCostClimbingStairs_3(int[] cost) {
        int len = cost.length;
        int[] arr = new int[len];
        arr[0] = cost[0];
        arr[1] = cost[1];

        for (int i = 2; i < len; i++) {
            arr[i] = Math.min(arr[i - 1], arr[i - 2]) + cost[i];
        }
        return Math.min(arr[len - 1], arr[len - 2]);
    }
}
