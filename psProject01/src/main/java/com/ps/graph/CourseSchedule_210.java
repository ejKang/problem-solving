package com.ps.graph;

import java.util.ArrayList;
import java.util.List;

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
}
