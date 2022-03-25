package com.ps.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] tmp : prerequisites) {
            indegree[tmp[0]]++;
            graph[tmp[1]].add(tmp[0]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            for (int g : graph[tmp]) {
                indegree[g]--;
                if (indegree[g] == 0) {
                    list.add(g);
                }
            }
        }
        if (list.size() != numCourses - 1) {
            return new int[0];
        }
        int[] rst = list.stream().mapToInt(Integer::intValue).toArray();
        return rst;
    }

    public static void main(String[] args) {
        CourseSchedule_210 c = new CourseSchedule_210();
        int[][] arr = { { 1, 0 } };
        c.findOrder_2(2, arr);
    }

    public int[] findOrder_2(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] vertex : prerequisites) {
            indegree[vertex[0]]++;
            graph.get(vertex[1]).add(vertex[0]);
        }

        // Queue<Integer> queue = new LinkedList<>();
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            int tmp = queue.get(i);

            for (int j : graph.get(tmp)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    queue.add(j);
                }
            }

        }
        if (Arrays.stream(indegree).sum() > 0) {
            return new int[0];
        }
        int[] rst = queue.stream().mapToInt(Integer::intValue).toArray();
        return rst;
    }
}
