package com.ps.dp;

public class MinCostForTickets_983 {

    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };

        MinCostForTickets_983 m = new MinCostForTickets_983();
        m.mincostTickets(days, costs);
    }

    public int mincostTickets(int[] days, int[] costs) {

        int[] temp = { 0, 7, 30 };
        int[] dp = new int[days.length];
        int rst = dfs(days, costs, 0, temp, dp);
        return rst;
    }

    private int dfs(int[] days, int[] costs, int idx, int[] temp, int[] dp) {
        if (idx >= days.length) {
            return 0;
        }
        if (dp[idx] != 0) {
            return dp[idx];
        }
        int min = Integer.MAX_VALUE;
        int currentdays = days[idx];

        for (int j = 0; j < temp.length; j++) {
            int tmpIdx = idx + 1;
            while (tmpIdx < days.length && days[tmpIdx] <= currentdays + temp[j] - 1) {
                tmpIdx++;
            }
            int tmp = dfs(days, costs, tmpIdx, temp, dp) + costs[j];

            min = Math.min(tmp, min);

        }
        dp[idx] = min;
        return min;
    }

    public int mincostTickets_2(int[] days, int[] costs) {
        int[] tmp = { 1, 7, 30 };
        int[] dp = new int[days.length];
        int rst = dfs_2(days, costs, tmp, 0, dp);
        return rst;
    }

    private int dfs_2(int[] days, int[] costs, int[] tmp, int idx, int[] dp) {
        if (idx >= days.length) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int currentDay = days[idx];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int tmpIdx = idx + 1;
            while (tmpIdx < days.length && currentDay + tmp[i] - 1 >= days[tmpIdx]) {
                tmpIdx++;
            }

            int tmpValue = dfs_2(days, costs, tmp, tmpIdx, dp) + costs[i];
            min = Math.min(tmpValue, min);
        }

        dp[idx] = min;

        return min;
    }
}
