package com.ps.a1dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        // int[][] dist = { { 0, 5, 2, 4, 1 }, { 5, 0, 3, 9, 6 }, { 2, 3, 0, 6, 3 }, {
        // 4, 9, 6, 0, 3 },
        // { 1, 6, 3, 3, 0 } };
        // s.sol(dist);
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 0 }, { 5, 1 }, { 6, 1 }, { 7, 2 }, { 7, 3 }, { 4, 5 },
                { 5, 6 }, { 6, 7 } };
        System.out.println(s.ssol3(8, edges, 4, 0, 3));
    }

    public int ssol3(int n, int[][] edges, int k, int a, int b) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        ddffss(graph, a, b, list, k, rst);

        for (List<Integer> fffIntegers : rst) {
            for (Integer integer : fffIntegers) {
                System.out.print(integer + ", ");

            }
            System.out.println("");
        }
        Set<String> set = new HashSet<>();
        for (List<Integer> tmp : rst) {

            for (int i = 0; i < tmp.size() - 1; i++) {
                int aa = tmp.get(i);
                int bb = tmp.get(i + 1);

                if (aa < bb) {
                    set.add(aa + "-" + bb);
                } else {
                    set.add(bb + "-" + aa);
                }
            }
        }
        return set.size();
    }

    private void ddffss(List<List<Integer>> graph, int a, int b, List<Integer> list, int k, List<List<Integer>> rst) {
        if (list.contains(a)) {
            return;
        }

        list.add(a);
        if (list.size() - 1 > k) {
            return;
        }

        if (a == b) {
            rst.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        for (int i : graph.get(a)) {
            ddffss(graph, i, b, list, k, rst);
        }

        list.remove(list.size() - 1);

    }

    public int sol2(String[] grid) {

        int y = grid.length;
        int x = grid[0].length();

        int rst = -1;
        char[][] chars = new char[y][x];
        boolean[][] visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                String s = grid[i];
                char sub = s.charAt(j);

                chars[i][j] = sub;
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                if (chars[i][j] == '?') {
                    chars[i][j] = 'a';
                    // visited[i][j] = true;
                    rst = dfs(chars, visited, i, j);

                    // rst = rst + dfs
                }
            }
        }
        return 1;
    }

    private int dfs(char[][] chars, boolean[][] visited, int y, int x) {
        if (visited[y][x]) {
            return 0;
        }
        return 0;
    }

    public int[][] sol(int[][] dist) {

        int len = dist.length;

        int max = Integer.MIN_VALUE;
        int y = 0;
        int x = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int tmp = dist[i][j];
                if (i == j) {
                    continue;
                }
                if (tmp > max) {
                    max = tmp;
                    y = i;
                    x = j;
                }

            }
        }

        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(y);
        list.add(y);
        visited[y] = true;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            int min = Integer.MAX_VALUE;
            int[] target = dist[k];
            int next = -1;
            for (int i = 0; i < len; i++) {
                if (i == k) {
                    continue;
                }
                if (target[i] < min && !visited[i]) {
                    min = target[i];
                    next = i;

                }
            }
            if (next != -1) {
                queue.offer(next);
                list.add(next);
                visited[next] = true;
            }

        }

        Collections.reverse(list);

        return null;
    }
}
