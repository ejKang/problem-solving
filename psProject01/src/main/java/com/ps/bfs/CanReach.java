package com.ps.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CanReach {

    public boolean canReach(int[] arr, int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] visited = new int[arr.length];
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int temp = queue.poll();

                if (arr[temp] == 0) {
                    return true;
                }
                if (visited[temp] == 0) {
                    if (temp + arr[temp] < arr.length) {
                        queue.offer(temp + arr[temp]);
                    }
                    if (temp - arr[temp] >= 0) {
                        queue.offer(temp - arr[temp]);
                    }
                }

                visited[temp] = 1;
            }
        }

        return false;
    }

}
