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

    public int openLock_2(String[] deadends, String target) {

        int cnt = 0;
        Set<String> visited = new HashSet<>();

        for (String str : deadends) {
            visited.add(str);
        }

        if (visited.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int k = 0; k < queueSize; k++) {
                String tmp = queue.poll();

                if (tmp.equals(target)) {
                    return cnt;
                }

                for (int i = 0; i < 4; i++) {
                    int targetNum = Integer.valueOf(tmp.substring(i, i + 1));

                    int up = (targetNum + 1) % 10;
                    int down = (targetNum - 1 + 10) % 10;

                    String upStr = tmp.substring(0, i) + up + tmp.substring(i + 1);
                    String downStr = tmp.substring(0, i) + down + tmp.substring(i + 1);

                    if (!visited.contains(upStr)) {
                        queue.add(upStr);
                        visited.add(upStr);
                    }

                    if (!visited.contains(downStr)) {
                        queue.add(downStr);
                        visited.add(downStr);
                    }
                }
            }
            cnt++;

        }
        return -1;
    }
}
