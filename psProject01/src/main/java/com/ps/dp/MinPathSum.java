package com.ps.dp;

public class MinPathSum {

    public static void main(String[] args) {
        System.out.println("sss");
    }

    public int minPathSum(int[][] grid) {
        int i = grid.length;
        int j = grid[0].length;

        // int[][] cost = new int[i][j];
        // cost[i - 1][j - 1] = dp(grid, cost, i - 1, j - 1);
        // return cost[i - 1][j - 1];

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {

                if (m == 0 && n != 0) {
                    grid[m][n] = grid[m][n] + grid[m][n - 1];
                } else if (m != 0 && n == 0) {
                    grid[m][n] = grid[m][n] + grid[m - 1][n];
                } else if (m != 0 && n != 0) {
                    grid[m][n] = grid[m][n] + Math.min(grid[m - 1][n], grid[m][n - 1]);
                }

            }
        }
        return grid[i - 1][j - 1];
    }

    public int dp(int[][] grid, int[][] cost, int i, int j) {

        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || i >= grid.length) {
            return Integer.MAX_VALUE;
        }
        if (j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (cost[i][j] != 0) {
            return cost[i][j];
        }
        int tempi = dp(grid, cost, i - 1, j);

        int tempj = dp(grid, cost, i, j - 1);

        int rst = Math.min(tempi, tempj) + grid[i][j];
        cost[i][j] = rst;
        return rst;
    }

    public int minPathSum1(int[][] grid) {

        int y = grid.length;
        int x = grid[0].length;
        int[][] cost = new int[y][x];
        cost[0][0] = grid[0][0];

        dynamicProgramming(grid, y - 1, x - 1, cost);
        return cost[y - 1][x - 1];
    }

    private int dynamicProgramming(int[][] grid, int y, int x, int[][] cost) {

        if (y - 1 < 0) {
            int a;
            if (cost[y][x - 1] == 0) {
                a = dynamicProgramming(grid, y, x - 1, cost);
            } else {
                a = cost[y][x - 1];
            }
            cost[y][x] = a + grid[y][x];
        } else if (x - 1 < 0) {
            int a;
            if (cost[y - 1][x] == 0) {
                a = dynamicProgramming(grid, y - 1, x, cost);
            } else {
                a = cost[y - 1][x];
            }

            cost[y][x] = a + grid[y][x];
        } else if (y - 1 < 0 && x - 1 < 0) {
            return 0;
        } else {
            int a;
            if (cost[y][x - 1] == 0) {
                a = dynamicProgramming(grid, y, x - 1, cost);
            } else {
                a = cost[y][x - 1];
            }
            int aa;
            if (cost[y - 1][x] == 0) {
                aa = dynamicProgramming(grid, y - 1, x, cost);
            } else {
                aa = cost[y - 1][x];
            }
            cost[y][x] = Math.min(a, aa) + grid[y][x];
        }

        return cost[y][x];
    }
}
