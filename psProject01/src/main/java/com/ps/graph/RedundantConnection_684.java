package com.ps.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedundantConnection_684 {
    public int[] findRedundantConnection(int[][] edges) {

        int[] parents = new int[edges.length + 1];
        for (int[] edge : edges) {
            int a = find(parents, edge[0]);
            int b = find(parents, edge[1]);

            if (a == b) {
                return edge;
            }
            parents[a] = b;
        }
        return new int[0];
    }

    private int find(int[] parents, int i) {
        if (parents[i] == 0) {
            return i;
        }
        return find(parents, parents[i]);
    }

    public int[] findRedundantConnection_dfs(int[][] edges) {
        int len = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i < len + 1; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dfs(map, u, v, new HashSet<>())) {
                return edge;
            }
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return new int[0];
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int source, int target, Set<Integer> visited) {
        if (target == source) {
            return true;
        }
        visited.add(source);
        for (int tmp : map.get(source)) {
            if (!visited.contains(tmp)) {
                if (dfs(map, tmp, target, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
