package com.ps.dp;

public class BestTimeToBuySellStock_122 {

    public int maxProfit(int[] prices) {

        int max = 0;

        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prev) {
                max += (prices[i] - prev);

            } else {

            }
            prev = prices[i];
        }
        return max;
    }
}
