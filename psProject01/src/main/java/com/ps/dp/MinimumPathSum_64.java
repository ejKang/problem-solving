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

        int y = grid.length;
        int x = grid[0].length;
        int[][] cost = new int[y][x];

        cost[0][0] = grid[0][0];

        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int tmpUp = Integer.MAX_VALUE;
                int tmpLeft = Integer.MAX_VALUE;

                // check upper side
                if (i - 1 >= 0) {
                    tmpUp = cost[i - 1][j];
                }

                if (j - 1 >= 0) {
                    tmpLeft = cost[i][j - 1];
                }

                cost[i][j] = grid[i][j] + Math.min(tmpLeft, tmpUp);
            }
        }

        return cost[y - 1][x - 1];
    }

    public int minPathSum_2_bottom_up(int[][] grid) {

        int x = grid[0].length;
        int y = grid.length;

        int[][] rst = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 && j == 0) {
                    rst[i][j] = grid[i][j];
                } else if (i == 0) {
                    rst[i][j] = grid[i][j] + rst[i][j - 1];
                } else if (j == 0) {
                    rst[i][j] = grid[i][j] + rst[i - 1][j];
                } else {
                    int tmp = Math.min(rst[i - 1][j], rst[i][j - 1]);
                    rst[i][j] = grid[i][j] + tmp;
                }

            }
        }
        return rst[y - 1][x - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum_64 s = new MinimumPathSum_64();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        s.minPathSum_2_top_dowm(grid);
    }

    public int minPathSum_2_top_dowm(int[][] grid) {

        int x = grid[0].length;
        int y = grid.length;

        int rst[][] = new int[y][x];
        rst[0][0] = grid[0][0];

        dp_2(grid, rst, y - 1, x - 1);

        return rst[y - 1][x - 1];
    }

    private void dp_2(int[][] grid, int[][] rst, int y, int x) {

        if (y < 0 || x < 0) {
            return;
        }

        if (y == 0 && x == 0) {
            return;
        }

        int tmpY = Integer.MAX_VALUE;
        if (y - 1 >= 0) {
            if (rst[y - 1][x] == 0) {
                dp_2(grid, rst, y - 1, x);
            }
            tmpY = rst[y - 1][x];
        }

        int tmpX = Integer.MAX_VALUE;
        if (x - 1 >= 0) {
            if (rst[y][x - 1] == 0) {
                dp_2(grid, rst, y, x - 1);
            }
            tmpX = rst[y][x - 1];
        }

        rst[y][x] = Math.min(tmpY, tmpX) + grid[y][x];

    }
}
