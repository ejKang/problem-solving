package com.ps.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSrcToTarget_797 {

    // graph - depth first search
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

    public List<List<Integer>> allPathsSourceTarget_2(int[][] graph) {
        List<List<Integer>> rst = new ArrayList<>();

        int len = graph.length;
        List<Integer> list = new ArrayList<>();
        backtracking_2(rst, graph, len, list, 0);

        return rst;
    }

    private void backtracking_2(List<List<Integer>> rst, int[][] graph, int len, List<Integer> list, int idx) {
        list.add(idx);
        if (len - 1 == idx) {
            rst.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for (int i : graph[idx]) {
            backtracking_2(rst, graph, len, list, i);
        }
        list.remove(list.size() - 1);
    }
}
