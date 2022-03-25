package com.ps.dp;

public class BestTimeToBuySellStock_121 {
    public int maxProfit(int[] prices) {

        int max = 0;
        // for (int i = 0; i < prices.length; i++) {
        // for (int j = i + 1; j < prices.length; j++) {
        // if (prices[j] > prices[i]) {
        // max = Math.max(max, prices[j] - prices[i]);
        // }
        // }
        // }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
