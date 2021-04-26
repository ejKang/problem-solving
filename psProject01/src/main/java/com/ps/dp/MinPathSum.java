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

        for (int m = 0; m < i ; m++) {
            for (int n = 0; n < j; n ++) {

                if (m == 0 && n!=0) {
                    grid[m][n] = grid[m][n] + grid[m][n-1];
                } else if (m != 0 && n==0) {
                    grid[m][n] = grid[m][n] + grid[m-1][n];
                } else if (m!=0 && n!=0) {
                    grid[m][n] = grid[m][n] + Math.min(grid[m-1][n], grid[m][n-1]);
                }

            }
        }
        return grid[i-1][j-1];
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

}
