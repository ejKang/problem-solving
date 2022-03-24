package com.ps.graph;

public class IslandPerimeter_463 {

    int cnt = 0;

    public int islandPerimeter(int[][] grid) {

        int y = grid.length;
        int x = grid[0].length;

        boolean[][] visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                recursive(i, j, grid, visited);
            }
        }
        return cnt;
    }

    private void recursive(int y, int x, int[][] grid, boolean[][] visited) {

        if (grid[y][x] == 0 || visited[y][x]) {
            return;
        }

        visited[y][x] = true;

        if (x - 1 < 0) {
            cnt++;
        } else if (x - 1 >= 0 && x - 1 < grid[0].length && grid[y][x - 1] == 0) {
            cnt++;
        } else if (x - 1 >= 0 && x - 1 < grid[0].length && grid[y][x - 1] == 1) {
            recursive(y, x - 1, grid, visited);
        }

        if (x + 1 == grid[0].length) {
            cnt++;
        } else if (x + 1 >= 0 && x + 1 < grid[0].length && grid[y][x + 1] == 0) {
            cnt++;
        } else if (x + 1 >= 0 && x + 1 < grid[0].length && grid[y][x + 1] == 1) {
            recursive(y, x + 1, grid, visited);
        }

        if (y - 1 < 0) {
            cnt++;
        } else if (y - 1 >= 0 && y - 1 < grid.length && grid[y - 1][x] == 0) {
            cnt++;
        } else if (y - 1 >= 0 && y - 1 < grid.length && grid[y - 1][x] == 1) {
            recursive(y - 1, x, grid, visited);
        }

        if (y + 1 == grid.length) {
            cnt++;
        } else if (y + 1 >= 0 && y + 1 < grid.length && grid[y + 1][x] == 0) {
            cnt++;
        } else if (y + 1 >= 0 && y + 1 < grid.length && grid[y + 1][x] == 1) {
            recursive(y + 1, x, grid, visited);
        }

    }
}
