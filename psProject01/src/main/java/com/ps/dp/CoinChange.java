package com.ps.dp;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] rst = new int[coins.length];
        return dp(coins, amount, rst);
    }

    private int dp(int[] coins, int remains, int[] rst) {

        if (remains < 0)
            return -1;
        if (remains == 0)
            return 0;
        if (rst[remains - 1] != 0)
            return rst[remains - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = dp(coins, remains - coin, rst);
            if (temp >= 0 && temp < min) {
                min = temp + 1; // add 1 -> add self count
            }
        }
        rst[remains - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return rst[remains - 1];
    }

}
