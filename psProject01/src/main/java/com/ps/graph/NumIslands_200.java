package com.ps.graph;

public class NumIslands_200 {

    public int numIslands(char[][] grid) {

        int rst = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                    rst++;
                }
            }
        }
        return rst;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int width = grid[0].length;
        int height = grid.length;

        if (i + 1 >= 0 && i + 1 < height && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            dfs(grid, visited, i + 1, j);
        }

        if (j + 1 >= 0 && j + 1 < width && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            dfs(grid, visited, i, j + 1);
        }

        if (i - 1 >= 0 && i - 1 < height && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            dfs(grid, visited, i - 1, j);
        }

        if (j - 1 >= 0 && j - 1 < width && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            dfs(grid, visited, i, j - 1);
        }

    }

    public static void main(String[] args) {
        // char
    }
}
