package com.ps.unionfind;

import java.util.Arrays;

public class FindRedundantConnection {
    
    public static void main(String[] args) {

        int [][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int [] rst = findRedundantConnection(edges);

        System.out.println(Arrays.toString(rst));
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[2001];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges ) {
            int from = edge[0], to = edge[1];
            if (find(from, parents) == find(to, parents)){
                return edge;
            }

            union(from, to, parents);
        }
        return null;
    }

    private static void union(int a, int b, int[] parents) {
        int aParent = find(a, parents);
        int bParent = find(b, parents);

        if (aParent == bParent) return;
        parents[aParent] = bParent;
    }

    private static int find(int node, int[] parents) {
        while(node != parents[node]) {
            node = parents[node];
        }
        return node;
    }
}
