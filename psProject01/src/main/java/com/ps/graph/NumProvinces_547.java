package com.ps.graph;

import java.util.Arrays;

public class NumProvinces_547 {
    public static void main(String[] args) {
        NumProvinces_547 p = new NumProvinces_547();
        int[][] isc = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
        System.out.println(p.findCircleNum(isc));
    }

    // graph - backtracking
    // time complexity - o(n)
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

    // graph - union find
    // time complexity - o(n^2)
    public int findCircleNum_union(int[][] isConnected) {
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

    public int findCircleNum_2_union_find(int[][] isConnected) {

        int len = isConnected.length;

        int[] parent = new int[len];

        for (int i = 0; i < len; i++) {
            int[] tmp = isConnected[i];

            for (int j = 0; j < len; j++) {
                if (tmp[j] == 1) {
                    int from = find_2(i, parent);
                    int to = find_2(j, parent);

                    if (from != to) {
                        // is not connected
                        parent[from] = to;
                    }
                }
            }
        }

        int aa = (int) Arrays.stream(parent).filter(i -> i == 0).count();
        return aa;
    }

    private int find_2(int idx, int[] parent) {
        if (parent[idx] == 0) {
            return idx;
        }
        return find_2(parent[idx], parent);
    }

    public int findCircleNum_2_backtracking(int[][] isConnected) {

        int len = isConnected.length;
        int cnt = 0;

        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {

            if (!visited[i]) {
                cnt++;
                backtracking(visited, i, isConnected);
            }
        }
        return cnt;
    }

    private void backtracking(boolean[] visited, int idx, int[][] isConnected) {
        int[] tmp = isConnected[idx];

        for (int i = 0; i < tmp.length; i++) {

            if (tmp[i] == 1 && !visited[i]) {
                visited[i] = true;
                backtracking(visited, i, isConnected);
            }
        }
    }

}
