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

    public int[][] merge_2(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] tmp = new int[intervals.length][2];
        tmp[0] = intervals[0];
        int tmpIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (tmp[tmpIdx][1] >= intervals[i][0]) {
                tmp[tmpIdx][1] = Math.max(tmp[tmpIdx][1], intervals[i][1]);
            } else {
                tmp[++tmpIdx] = intervals[i];
            }
        }

        int[][] rst = new int[++tmpIdx][2];

        for (int i = 0; i < tmpIdx; i++) {
            rst[i] = tmp[i];
        }
        return rst;
    }
}
