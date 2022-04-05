package com.ps.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> list = Arrays.asList(deadends);

        visited.addAll(list);
        String startPoint = "0000";

        if (visited.contains(startPoint)) {
            return -1;
        }

        queue.offer(startPoint);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();

                if (visited.contains(tmp)) {
                    continue;
                }

                if (tmp.equals(target)) {
                    return cnt;
                }

                visited.add(tmp);
                for (int j = 0; j < tmp.length(); j++) {
                    int k = Integer.valueOf(tmp.substring(j, j + 1));

                    int plus = (k + 1) % 10;
                    int minus = (k - 1 + 10) % 10;

                    String plusStr = tmp.substring(0, j) + plus + tmp.substring(j + 1);
                    String minStr = tmp.substring(0, j) + minus + tmp.substring(j + 1);

                    queue.offer(plusStr);
                    queue.offer(minStr);
                }

            }
            cnt++;
        }
        return -1;
    }
}
