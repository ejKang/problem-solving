package com.ps.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge_934 {
    public int shortestBridge(int[][] grid) {

        int len = grid.length;

        boolean[][] visited = new boolean[len][len];
        Queue<Integer[]> queue = new LinkedList<>();

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    // start point
                    backtracking(grid, visited, i, j, queue);

                    int cnt = 0;
                    while (!queue.isEmpty()) {
                        int qsize = queue.size();
                        for (int k = 0; k < qsize; k++) {
                            Integer[] tmp = queue.poll();
                            for (int[] d : dir) {
                                Integer[] newPosition = { tmp[0].intValue() + d[0], tmp[1].intValue() + d[1] };
                                if (!isValid(newPosition, len)) {
                                    continue;
                                }
                                if (!visited[newPosition[0]][newPosition[1]]
                                        && grid[newPosition[0]][newPosition[1]] == 1) {
                                    return cnt;
                                }
                                if (!visited[newPosition[0]][newPosition[1]]) {
                                    visited[newPosition[0]][newPosition[1]] = true;
                                    queue.offer(newPosition);
                                }
                            }
                        }
                        cnt++;
                    }
                    return cnt;
                }
            }
        }
        return -1;
    }

    private boolean isValid(Integer[] tt, int len) {
        int y = tt[0];
        int x = tt[1];

        if (y < 0 || x < 0 || y > len - 1 || x > len - 1) {
            return false;
        }
        return true;
    }

    private void backtracking(int[][] grid, boolean[][] visited, int y, int x, Queue<Integer[]> queue) {

        if (y < 0 || x < 0 || y > grid.length - 1 || x > grid[0].length - 1) {
            return;
        }

        if (visited[y][x]) {
            return;
        }
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        if (grid[y][x] == 1) {
            visited[y][x] = true;
            Integer[] tmp = { y, x };
            queue.offer(tmp);

            for (int[] point : dir) {
                backtracking(grid, visited, y + point[0], x + point[1], queue);
            }
        }

        return;
    }

    public int shortestBridge_2(int[][] grid) {
        int len = grid.length;
        boolean[][] visited = new boolean[len][len];
        Queue<Integer[]> queue = new LinkedList<>();

        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len; j++) {

                if (grid[i][j] == 1) {
                    findAllCurrentIsland(grid, visited, queue, i, j);

                    int cnt = 0;
                    while (!queue.isEmpty()) {
                        int queueSize = queue.size();

                        for (int k = 0; k < queueSize; k++) {
                            Integer[] tmp = queue.poll();

                            for (int[] dir : direction) {
                                if (!validPosition(tmp[0] + dir[0], tmp[1] + dir[1], len)) {
                                    continue;
                                }

                                Integer[] newValue = { tmp[0] + dir[0], tmp[1] + dir[1] };

                                if (visited[newValue[0]][newValue[1]]) {
                                    continue;
                                }
                                if (grid[newValue[0]][newValue[1]] == 1) {
                                    return cnt;
                                }
                                visited[newValue[0]][newValue[1]] = true;
                                queue.offer(newValue);
                            }
                        }
                        cnt++;
                    }

                    return -1;
                }
            }
        }
        return -1;
    }

    private void findAllCurrentIsland(int[][] grid, boolean[][] visited, Queue<Integer[]> queue, int y, int x) {

        if (!validPosition(y, x, grid.length)) {
            return;
        }

        if (grid[y][x] != 1) {
            return;
        }

        if (visited[y][x]) {
            return;
        }

        visited[y][x] = true;
        Integer[] target = { y, x };
        queue.offer(target);

        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int[] dir : direction) {
            findAllCurrentIsland(grid, visited, queue, y + dir[0], x + dir[1]);
        }
    }

    private boolean validPosition(int y, int x, int length) {

        if (y < 0 || x < 0 || y > length - 1 || x > length - 1) {
            return false;
        }

        return true;

    }
}
