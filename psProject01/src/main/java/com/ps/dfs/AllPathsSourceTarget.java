package com.ps.dfs;

import java.util.List;

public class AllPathsSourceTarget {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int target = graph.length;


        for (int j = 0; j < graph[0].length; j++) {
            int temp = graph[0][j];
            dfs(target, temp,graph);
        }


        return null;
    }

    private void dfs(int target, int idx,int[][] graph) {
        for (int j = 0; j < graph[idx].length; j++) {
            int temp = graph[0][j];
            if (temp == target) {
                //found ! ;
            } else {
                dfs(target, temp, graph);
            }
            
        }

    }
}
