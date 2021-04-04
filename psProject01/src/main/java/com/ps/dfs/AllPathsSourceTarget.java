package com.ps.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs (graph, 0, rst, path);
        return rst;
    }

    private void dfs(int[][] graph, int i, List<List<Integer>> rst, List<Integer> path) {

        if (i == graph.length -1) {
            rst.add(new ArrayList<>(path));
            return ;
        }

        for (int idx : graph[i]) {
            path.add(idx);
            dfs(graph, idx, rst, path);
            path.remove(path.size() -1 );
        }
    }

}
