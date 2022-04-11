package com.ps.graph;

import java.util.ArrayList;
import java.util.List;

public class MinNumOfVerticeToReachAllNodes_1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> rst = new ArrayList<>();
        int[] indegree = new int[n];

        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            indegree[to]++;

        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                rst.add(i);
            }
        }

        return rst;
    }

    public List<Integer> findSmallestSetOfVertices_2(int n, List<List<Integer>> edges) {

        List<Integer> rst = new ArrayList<>();
        int[] indegree = new int[n];

        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            indegree[to]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                rst.add(i);
            }
        }
        return rst;
    }
}
