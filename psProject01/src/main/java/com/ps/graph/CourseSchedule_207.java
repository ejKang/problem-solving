package com.ps.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            for (int tmp : graph[idx]) {
                inDegree[tmp]--;
                if (inDegree[tmp] == 0) {
                    queue.offer(tmp);
                }
            }
        }

        return Arrays.stream(inDegree).sum() == 0;
    }

    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[numCourses];
        for (int[] tmp : prerequisites) {
            graph[tmp[1]].add(tmp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, boolean[] visited, int idx) {
        if (visited[idx]) {
            return false;
        }
        visited[idx] = true;

        for (int tmp : graph[idx]) {
            if (!dfs(graph, visited, tmp)) {
                return false;
            }
        }
        visited[idx] = false;
        return true;
    }

}
