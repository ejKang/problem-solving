package com.ps.a1tt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 s = new Solution_1();
        int[][] roads = { { 0, 1, 2 }, { 0, 2, 3 } };
        s.sol(4, 10, roads);
    }

    public int[] sol(int n, int k, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);

            int tmp1 = roads[i][0];
            int tmp2 = roads[i][1];

            if (tmp1 < tmp2) {
                map.put(tmp1 + "-" + tmp2, roads[i][2]);
            } else {
                map.put(tmp2 + "-" + tmp1, roads[i][2]);
            }

        }

        Set<Integer> rst = new HashSet<>();

        dfs(rst, map, graph, 0, 0, k);
        List<Integer> list = new ArrayList<>(rst);

        if (list.size() == 0) {
            int[] failed = { -1 };
            return failed;
        }
        Collections.sort(list);
        int[] ii = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ii[i] = list.get(i);
        }
        // System.out.println(rst);
        return ii;
    }

    private void dfs(Set<Integer> rst, Map<String, Integer> map, List<List<Integer>> graph, int idx, int tmpLen,
            int target) {

        if (tmpLen == target) {
            rst.add(idx);
            return;
        } else if (tmpLen > target) {
            return;
        }

        for (int i : graph.get(idx)) {

            String key = "";
            if (i < idx) {
                key = i + "-" + idx;
            } else {
                key = idx + "-" + i;
            }

            int tmp = tmpLen + map.get(key);
            dfs(rst, map, graph, i, tmp, target);
        }
    }
}
