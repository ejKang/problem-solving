package com.ps.dp;

public class CoinChange_322 {
    public static void main(String[] args) {
        CoinChange_322 c = new CoinChange_322();
        int[] coins = { 2 };
        // c.coinChange(coins, 3);
        c.coinChange_2(coins, 3);
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

    public int coinChange_2(int[] coins, int amount) {
        int[] rst = new int[amount + 1];

        for (int i : coins) {
            rst[i] = 1;
        }

        dp_2_top_down(coins, rst, amount);

        if (rst[amount] == 0) {
            return -1;
        }
        return rst[amount];
    }

    private int dp_2_top_down(int[] coins, int[] rst, int amount) {

        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        } else if (rst[amount] != 0) {
            return rst[amount];
        }

        int tmp = Integer.MAX_VALUE;

        for (int coin : coins) {
            int t = dp_2_top_down(coins, rst, amount - coin);

            if (t != -1 && t < tmp) {
                tmp = t + 1;
            }
        }

        if (tmp != Integer.MAX_VALUE) {
            rst[amount] = tmp;
        } else {
            rst[amount] = -1;
            tmp = -1;
        }
        return tmp;
    }

    public int coinChange_2_bottom_up(int[] coins, int amount) {
        int rst[] = new int[amount + 1];

        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {

                if (i - coin < 0) {
                    continue;
                } else if (i - coin == 0) {
                    min = 0;
                } else if (i - coin > 0) {
                    min = Math.min(min, rst[i - coin]);
                }
            }

            if (min == Integer.MAX_VALUE) {
                rst[i] = -1;
            } else {
                rst[i] = min + 1;
            }
        }
        return rst[amount];
    }

    public int coinChange_3(int[] coins, int amount) {

        int[] coinCnt = new int[amount + 1];

        for (int coin : coins) {
            if (coin <= amount) {
                coinCnt[coin] = 1;

            }
        }

        dynamicProgramming_3(coins, coinCnt, amount);
        return coinCnt[amount];
    }

    private int dynamicProgramming_3(int[] coins, int[] coinCnt, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        } else if (coinCnt[amount] != 0) {
            return coinCnt[amount];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int tmp = dynamicProgramming_3(coins, coinCnt, amount - coin);

            if (tmp != -1 && min > tmp) {
                min = tmp + 1;
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        coinCnt[amount] = min;

        return min;
    }
}
