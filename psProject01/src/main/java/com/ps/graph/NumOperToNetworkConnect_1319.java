package com.ps.graph;

import java.util.Arrays;

public class NumOperToNetworkConnect_1319 {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int loopCnt = 0;
        int nodeCnt = 0;

        for (int[] con : connections) {
            int aParent = find(parent, con[0]);
            int bParent = find(parent, con[1]);

            if (aParent == bParent) {
                loopCnt++;
            } else {
                parent[aParent] = bParent;
            }
        }

        nodeCnt = (int) Arrays.stream(parent).filter(i -> i == 0).count();
        if (loopCnt >= nodeCnt - 1) {
            return nodeCnt - 1;
        }
        return -1;
    }

    private int find(int[] parent, int i) {

        if (parent[i] == 0) {
            return i;
        }
        return find(parent, parent[i]);
    }
}
