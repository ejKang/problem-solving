package com.ps.array;

import java.util.Arrays;

public class MaximunWealth {
    
    public int maximumWealth(int[][] accounts) {

        int cnt = accounts.length;

        int max = 0;
        for (int i = 0; i< cnt; i++) {
            int sum = Arrays.stream(accounts[i]).sum();
            max = Math.max(sum, max);
        }

        return max;
    }

}
