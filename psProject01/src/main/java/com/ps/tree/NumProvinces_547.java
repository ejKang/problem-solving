package com.ps.tree;

import java.util.Arrays;

public class NumProvinces_547 {
    public static void main(String[] args) {
        NumProvinces_547 p = new NumProvinces_547();
        int[][] isc = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        System.out.println(p.findCircleNum(isc));
    }

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[isConnected.length];
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                bt(isConnected, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void bt(int[][] isConnected, boolean[] visited, int idx) {
        for (int i = 0; i < visited.length; i++) {
            if (isConnected[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                bt(isConnected, visited, i);
            }
        }
    }

    public int findCircleNum_2(int[][] isConnected) {
        int len = isConnected.length;

        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                if (isConnected[i][j] == 1) {
                    int iParent = find(parent, i);
                    int jParent = find(parent, j);

                    if (iParent != jParent) {
                        parent[iParent] = jParent;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        int a = (int) Arrays.stream(parent).filter(f -> f == 0).count();
        return a;
    }

    private int find(int[] parent, int i) {

        if (parent[i] == 0) {
            return i;
        }
        return find(parent, parent[i]);
    }
}
