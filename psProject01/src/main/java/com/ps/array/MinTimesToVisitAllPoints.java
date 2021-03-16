package com.ps.array;

public class MinTimesToVisitAllPoints {
    
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int rst = 0;
        for (int i = 0; i< points.length -1; i++) {
            int[] first = points[i];
            int[] second = points[i+1];

            int x = Math.abs(first[0] - second[0]);
            int y = Math.abs(first[1] - second[1]);

            rst += Math.max(x, y);
        }

        return rst;
    }
}
