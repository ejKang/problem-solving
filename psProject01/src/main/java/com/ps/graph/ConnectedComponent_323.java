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

    public int countComponents_2(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = graph.get(edges[i][0]);
            list.add(edges[i][1]);
        }
        boolean[] visited = new boolean[edges.length];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cnt++;
                recursive(graph, visited, i);
            }
        }

        return cnt;
    }

    private void recursive(List<List<Integer>> graph, boolean[] visited, int idx) {

        for (int i : graph.get(idx)) {
            if (!visited[i]) {
                visited[idx] = true;
                recursive(graph, visited, i);
            }

        }

    }

    public int countComponents_3(int n, int[][] edges) {

        // make graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] tmp : edges) {
            graph.get(tmp[0]).add(tmp[1]);
        }
        boolean[] visited = new boolean[n];

        // visit graph
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                recursive_3(graph, graph.get(i), visited);
            }
        }
        return cnt;
    }

    private void recursive_3(List<List<Integer>> graph, List<Integer> list, boolean[] visited) {
        for (int i : list) {
            if (!visited[i]) {
                visited[i] = true;
                recursive_3(graph, graph.get(i), visited);
            }
        }
    }
}
