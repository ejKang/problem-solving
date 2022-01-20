package com.ps.array;

import java.util.Arrays;

public class RotateImage_48 {

    public void rotate_n2(int[][] matrix) {
        int[][] t = new int[matrix[0].length][matrix.length];
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                t[j][n - i] = matrix[i][j];
            }
        }

        matrix = t;
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = t[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
        int tmp = 0;

        int n = matrix.length - 1;
        for (int y = 0; y < matrix.length / 2; y++) {
            for (int x = 0; x < (matrix.length + 1) / 2; x++) {
                tmp = matrix[y][x];
                int x1 = y, y1 = n-x;
                int x2 = y1, y2 = n-x1;
                int x3 = y2, y3 = n-x2;

                matrix[y][x] = matrix[y1][x1];
                matrix[y1][x1] = matrix[y2][x2];
                matrix[y2][x2] = matrix[y3][x3];
                matrix[y3][x3] = tmp;
            }
        }
    }
}
