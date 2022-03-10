package com.ps.dp;

public class KnapSack {

    static Integer[][] dp;
    static int[] weight = { 6, 4, 3, 5 };
    static int[] value = { 13, 8, 6, 12 };

    public static void main(String[] args) {

        int itemCnt = 4;
        int totalWeight = 7;

        // weight = new int[itemCnt + 1];
        // value = new int[itemCnt + 1];

        dp = new Integer[itemCnt][totalWeight + 1];

        KnapSack topDown = new KnapSack();
        System.out.println(topDown.knapsack_top_down(itemCnt - 1, totalWeight));
        System.out.println(topDown.knapsack_2_top_down(itemCnt, totalWeight));
        // topDown.knapsack_bottom_up();
        System.out.println(topDown.knapsack_2_bottom_up(itemCnt, totalWeight));
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

    public int knapsack_2_top_down(int itemCnt, int totalWeight) {

        int[] weight_2 = { 6, 4, 3, 5 };
        int[] value_2 = { 13, 8, 6, 12 };

        Integer[][] rst = new Integer[itemCnt + 1][totalWeight + 1];

        // dp(rst, itemCnt, totalWeight, weight_2, value_2);
        // return rst[itemCnt][totalValue];
        return dp(rst, itemCnt, totalWeight, weight_2, value_2);
    }

    private int dp(Integer[][] rst, int itemCnt, int totalWeight, int[] weight_2, int[] value_2) {
        // System.out.println("itemCnt : " + itemCnt + " , totalWeight : " +
        // totalWeight);

        if (itemCnt <= 0 || totalWeight <= 0) {
            return 0;
        }

        if (rst[itemCnt][totalWeight] == null) {

            if (totalWeight - weight_2[itemCnt - 1] < 0) {
                rst[itemCnt][totalWeight] = dp(rst, itemCnt - 1, totalWeight, weight_2, value_2);
            } else {
                int tmp1 = dp(rst, itemCnt - 1, totalWeight, weight_2, value_2);

                int tmp2 = dp(rst, itemCnt - 1, totalWeight - weight_2[itemCnt - 1], weight_2, value_2);

                rst[itemCnt][totalWeight] = Math.max(tmp1, tmp2 + value_2[itemCnt - 1]);
            }

        }
        // System.out.println("itemCnt : " + itemCnt + " , totalWeight : " + totalWeight
        // +
        // " , rst[][] : " + rst[itemCnt][totalWeight]);
        return rst[itemCnt][totalWeight];
    }

    public int knapsack_2_bottom_up(int itemCnt, int totalWeight) {

        int[] weight_2 = { 6, 4, 3, 5 };
        int[] value_2 = { 13, 8, 6, 12 };

        Integer[][] rst = new Integer[itemCnt + 1][totalWeight + 1];

        for (int item = 0; item <= itemCnt; item++) {
            for (int wei = 0; wei <= totalWeight; wei++) {

                if (wei == 0 || item == 0) {
                    rst[item][wei] = 0;
                    continue;
                }
                if (wei < weight_2[item - 1]) {
                    rst[item][wei] = rst[item - 1][wei];
                    continue;
                } else {
                    rst[item][wei] = Math.max(rst[item - 1][wei],
                            rst[item - 1][wei - weight_2[item - 1]] + value_2[item - 1]);
                }

            }
        }
        return rst[itemCnt][totalWeight];
    }

}
