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

}
