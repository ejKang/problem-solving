package com.ps.greedy;

import java.util.Arrays;

public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int rst = 0;

        for (int[] box : boxTypes) {

            if (truckSize == 0) {
                break;
            }

            if (box[0] <= truckSize) {
                rst += box[1] * box[0];
                truckSize -= box[0];
            } else {
                rst += box[1] * truckSize;
                truckSize = 0;
            }
        }
        return rst;
    }
}
