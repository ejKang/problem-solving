package com.ps.dp;

public class CoinChange_322 {
    public static void main(String[] args) {
        CoinChange_322 c = new CoinChange_322();
        int[] coins = { 2 };
        c.coinChange(coins, 3);
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        int[] tmp = new int[amount + 1];
        return dp(coins, tmp, amount);
    }

    private int dp(int[] coins, int[] cnt, int remains) {

        if (remains < 0) {
            return -1;
        } else if (remains == 0) {
            return 0;
        } else if (cnt[remains] != 0) {
            return cnt[remains];
        }

        int tmp = Integer.MAX_VALUE;

        for (int coin : coins) {
            int rst = dp(coins, cnt, remains - coin);

            if (rst != -1 && rst < tmp) {
                tmp = rst + 1;
            }
        }

        if (tmp != Integer.MAX_VALUE) {
            cnt[remains] = tmp;
            return tmp;
        } else {
            cnt[remains] = -1;
            return -1;
        }

    }

    public int coinChange_bottom_up(int[] coins, int amount) {

        int[] cnt = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                } else if (cnt[i - coin] > 0) {
                    min = Math.min(min, cnt[i - coin]);
                } else if (i - coin == 0) {
                    min = 0;
                }
            }

            if (min == Integer.MAX_VALUE) {
                cnt[i] = -1;
            } else {
                cnt[i] = min + 1;
            }
        }
        return cnt[amount];
    }
}
