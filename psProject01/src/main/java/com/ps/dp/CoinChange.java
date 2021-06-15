package com.ps.dp;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] rst = new int[amount];
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

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] cnt = new int[amount];
        return dynamicprogramming(coins, amount, cnt);

    }

    private int dynamicprogramming(int[] coins, int amount, int[] cnt) {

        if (amount < 0) {
            return -1;
        }
        if (amount == 0)
            return 0;
        if (cnt[amount - 1] != 0)
            return cnt[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = dynamicprogramming(coins, amount - coin, cnt);
            if (tmp >= 0 && tmp < min)
                min = tmp + 1;
        }
        cnt[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return cnt[amount - 1];
    }
}
