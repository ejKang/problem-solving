package com.ps.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSrcToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> rst = new ArrayList<>();
        int[] startPoint = graph[0];

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i : startPoint) {
            backtracking(rst, list, graph, i);
        }
        return rst;
    }

    private void backtracking(List<List<Integer>> rst, List<Integer> list, int[][] graph, int idx) {
        list.add(idx);
        if (idx == graph.length - 1) {
            rst.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        int[] target = graph[idx];
        for (int i : target) {
            backtracking(rst, list, graph, i);
        }
        list.remove(list.size() - 1);

    }
}
