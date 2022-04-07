package com.ps.graph;

import java.util.Arrays;

public class NumOperToNetworkConnect_1319 {

    // graph - union find
    // time complexity - o(n^2)
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int loopCnt = 0;
        int nodeCnt = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] con : connections) {
            int aParent = find(parent, con[0]);
            int bParent = find(parent, con[1]);

            if (aParent == bParent) {
                loopCnt++;
            } else {
                parent[aParent] = bParent;
            }
        }

        // nodeCnt = (int) Arrays.stream(parent).filter(i -> i == 0).count();
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                nodeCnt++;
            }
        }
        if (loopCnt >= nodeCnt - 1) {
            return nodeCnt - 1;
        }
        return -1;
    }

    // private int find(int[] parent, int i) {

    // if (parent[i] == 0) {
    // return i;
    // }
    // return find(parent, parent[i]);
    // }
    private int find(int[] parent, int i) {

        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public int makeConnected_2(int n, int[][] connections) {
        int[] parent = new int[n];

        int cycle = 0;
        for (int[] con : connections) {

            int from = find_2(con[0], parent);
            int to = find_2(con[1], parent);

            if (from == to) {
                // cycle !
                cycle++;
            } else {
                parent[from] = to;
            }
        }

        int edgeCnt = (int) Arrays.stream(parent).filter(i -> i == 0).count();
        if (cycle + 1 >= edgeCnt) {
            return edgeCnt - 1;
        }
        return -1;
    }

    private int find_2(int i, int[] parent) {

        if (parent[i] == 0) {
            return i;
        }
        return find_2(parent[i], parent);
    }
}
