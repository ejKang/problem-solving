package com.ps.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponent_323 {

    public int countComponents(int n, int[][] edges) {

        // make graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        // dfs search
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(graph, i, visited);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(List<List<Integer>> graph, int i, boolean[] visited) {

        for (int j : graph.get(i)) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(graph, j, visited);
            }
        }
    }
}
