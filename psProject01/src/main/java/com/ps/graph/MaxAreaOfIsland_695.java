package com.ps.graph;

public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {

        int y = grid.length;
        int x = grid[0].length;
        boolean[][] visited = new boolean[y][x];

        int max = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == 1) {
                    int tmp = recursive(i, j, grid, visited) + 1;
                    max = Math.max(max, tmp);
                }
            }
        }
        return max;
    }

    private int recursive(int y, int x, int[][] grid, boolean[][] visited) {
        int tmp = 0;
        visited[y][x] = true;
        if (y - 1 >= 0 && y - 1 < grid.length && grid[y - 1][x] == 1 && !visited[y - 1][x]) {
            tmp = tmp + 1 + recursive(y - 1, x, grid, visited);
        }

        if (y + 1 >= 0 && y + 1 < grid.length && grid[y + 1][x] == 1 && !visited[y + 1][x]) {
            tmp = tmp + 1 + recursive(y + 1, x, grid, visited);
        }

        if (x + 1 >= 0 && x + 1 < grid[0].length && grid[y][x + 1] == 1 && !visited[y][x + 1]) {
            tmp = tmp + 1 + recursive(y, x + 1, grid, visited);
        }

        if (x - 1 >= 0 && x - 1 < grid[0].length && grid[y][x - 1] == 1 && !visited[y][x - 1]) {
            tmp = tmp + 1 + recursive(y, x - 1, grid, visited);
        }
        return tmp;
    }
}
