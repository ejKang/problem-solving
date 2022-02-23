package com.ps.dp;

public class MinimumPathSum_64 {

    // top down
    public int minPathSum(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        cost[0][0] = grid[0][0];
        dp(grid, cost, grid.length - 1, grid[0].length - 1);
        return cost[grid.length - 1][grid[0].length - 1];
    }

    private void dp(int[][] grid, int[][] cost, int i, int j) {

        if (i < 0 || j < 0) {
            return;
        } else if (i == 0 && j == 0) {
            return;
        }
        int tmpI = Integer.MAX_VALUE;

        if (i - 1 >= 0) {
            if (cost[i - 1][j] == 0) {
                dp(grid, cost, i - 1, j);
            }
            tmpI = cost[i - 1][j];
        }

        int tmpJ = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            if (cost[i][j - 1] == 0) {
                dp(grid, cost, i, j - 1);
            }
            tmpJ = cost[i][j - 1];
        }

        cost[i][j] = Math.min(tmpI, tmpJ) + grid[i][j];
    }

    public int minPathSum_bottom_up(int[][] grid) {
        return 0;
    }
}
