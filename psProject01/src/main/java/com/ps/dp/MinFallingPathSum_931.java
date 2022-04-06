package com.ps.dp;

import java.util.Arrays;

public class MinFallingPathSum_931 {
    public static void main(String[] args) {
        MinFallingPathSum_931 m = new MinFallingPathSum_931();
        int[][] matrix = { { 17, 82 }, { 1, -44 } };
        System.out.println(m.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {

        for (int i = 1; i < matrix[0].length; i++) {
            dp(i, matrix);
        }
        int len = matrix.length;

        return Arrays.stream(matrix[len - 1]).min().getAsInt();
    }

    private void dp(int y, int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            int min = Integer.MAX_VALUE;
            if (i == 0) {
                min = Math.min(matrix[y - 1][i], matrix[y - 1][i + 1]);
            } else if (i == matrix.length - 1) {
                min = Math.min(matrix[y - 1][i - 1], matrix[y - 1][i]);
            } else {
                min = Math.min(matrix[y - 1][i - 1], matrix[y - 1][i]);
                min = Math.min(min, matrix[y - 1][i + 1]);
            }
            matrix[y][i] = matrix[y][i] + min;
        }
    }

    // time complexity - o(n^2)
    // backtracking - time limit exceeded
    // public int minFallingPathSum_2(int[][] matrix) {
    // int len = matrix.length;

    // int min = Integer.MAX_VALUE;
    // for (int i = 0; i < len; i++) {

    // int tmp = backtracking(0, i, matrix) + matrix[0][i];
    // min = Math.min(tmp, min);
    // }
    // return min;
    // }

    // private int backtracking(int y, int x, int[][] matrix) {
    // if (y == matrix.length - 1) {
    // return 0;
    // }
    // int min = Integer.MAX_VALUE;
    // for (int i = -1; i < 2; i++) {
    // if (x + i < 0 || x + i >= matrix.length) {
    // continue;
    // }

    // int tmp = backtracking(y + 1, x + i, matrix) + matrix[y + 1][x + i];
    // min = Math.min(tmp, min);
    // }
    // return min;
    // }

    public int minFallingPathSum_2(int[][] matrix) {
        int len = matrix.length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {

            int tmp = backtracking(0, i, matrix);
            min = Math.min(tmp, min);
        }
        return min;
    }

    private int backtracking(int y, int x, int[][] matrix) {
        if (y == matrix.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = -1; i < 2; i++) {
            if (x + i < 0 || x + i >= matrix.length) {
                continue;
            }

            int tmp = backtracking(y + 1, x + i, matrix) + matrix[y][x + i];
            min = Math.min(tmp, min);
        }
        return min;
    }

    public int minFallingPathSum_3(int[][] matrix) {

        int len = matrix.length;
        for (int i = 1; i < len; i++) {
            dynamicProgramming(i, matrix);
        }

        int min = Arrays.stream(matrix[len - 1]).min().getAsInt();
        return min;
    }

    private void dynamicProgramming(int y, int[][] matrix) {
        int len = matrix.length;
        if (y == len) {
            return;
        }

        for (int i = 0; i < len; i++) {

            if (i == 0) {
                matrix[y][i] = Math.min(matrix[y - 1][i], matrix[y - 1][i + 1]) + matrix[y][i];
            } else if (i == len - 1) {
                matrix[y][i] = Math.min(matrix[y - 1][i], matrix[y - 1][i - 1]) + matrix[y][i];
            } else {
                int tmp = Math.min(matrix[y - 1][i], matrix[y - 1][i - 1]);
                matrix[y][i] = Math.min(tmp, matrix[y - 1][i + 1]) + matrix[y][i];
            }
        }
    }
}
