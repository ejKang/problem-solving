package com.ps.array;

import java.util.Arrays;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {

        // sorting - time complex - o(nlogn)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] rst = new int[intervals.length][2];
        rst[0] = intervals[0];
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (rst[j][1] >= intervals[i][0]) {
                // join
                rst[j][1] = Math.max(rst[j][1], intervals[i][1]);
            } else {
                rst[++j] = intervals[i];
            }
        }

        int[][] r = new int[j + 1][2];
        for (int i = 0; i < j + 1; i++) {
            r[i] = rst[i];
        }

        return r;
    }
}
