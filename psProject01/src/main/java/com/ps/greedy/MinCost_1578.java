package com.ps.greedy;

public class MinCost_1578 {

    public int minCost(String s, int[] cost) {

        int rst = 0;

        char current = 'A';
        int max = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == current) {

                if (max < cost[i]) {
                    rst += max;
                    max = cost[i];
                } else {
                    rst += cost[i];
                }

            } else {
                current = charArr[i];
                max = cost[i];
            }
        }

        return rst;
    }

    public int minCost2(String s, int[] cost) {

        int rst = 0;
        char[] charArr = s.toCharArray();
        for (int i = 1 ; i < cost.length; i++) {

            if (charArr[i] == charArr[i-1]) {

                rst += Math.min(cost[i], cost[i-1]);
                cost[i] = Math.max(cost[i], cost[i-1]);
            }

        }
        return rst;
    }

}
