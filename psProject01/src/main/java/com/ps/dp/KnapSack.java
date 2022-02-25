package com.ps.dp;

public class KnapSack {

    static Integer[][] dp;
    static int[] weight = { 6, 4, 3, 5 };
    static int[] value = { 13, 8, 6, 12 };

    public static void main(String[] args) {

        int itemCnt = 4;
        int totalValue = 7;

        // weight = new int[itemCnt + 1];
        // value = new int[itemCnt + 1];

        dp = new Integer[itemCnt][totalValue + 1];

        KnapSack topDown = new KnapSack();
        System.out.println(topDown.knapsack_top_down(itemCnt - 1, totalValue));

        topDown.knapsack_bottom_up();
    }

    public int knapsack_top_down(int itemCnt, int totalValue) {

        if (itemCnt < 0) {
            return 0;
        }

        if (dp[itemCnt][totalValue] == null) {
            if (weight[itemCnt] > totalValue) {
                dp[itemCnt][totalValue] = knapsack_top_down(itemCnt - 1, totalValue);
            } else {
                dp[itemCnt][totalValue] = Math.max(knapsack_top_down(itemCnt - 1, totalValue),
                        knapsack_top_down(itemCnt - 1, totalValue - weight[itemCnt]) + value[itemCnt]);
            }
        }
        return dp[itemCnt][totalValue];
    }

    public void knapsack_bottom_up() {

        int[] weight = { 0, 6, 4, 3, 5 };
        int[] value = { 0, 13, 8, 6, 12 };

        int itemCnt = 4;
        int totalValue = 7;

        int[][] dp = new int[itemCnt + 1][totalValue + 1];

        for (int i = 1; i <= itemCnt; i++) {

            for (int j = 1; j <= totalValue; j++) {

                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println("bottom-up : " + dp[itemCnt][totalValue]);
    }
}
