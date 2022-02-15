package com.ps.array;

public class SearchMatrix2_240 {

    // time complexity - o(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix[0].length - 1;
        int y = 0;

        while (x >= 0 && y < matrix.length) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }

    // time complexity = o(n2logn)
    public boolean searchMatrix_n2logn(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {

            int j = 0, k = matrix[i].length - 1;
            while (k >= j) {
                int pivot = (j + k) / 2;
                if (matrix[i][pivot] == target) {
                    return true;
                } else if (matrix[i][pivot] > target) {
                    k = pivot - 1;
                } else {
                    j = pivot + 1;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix_2(int[][] matrix, int target) {

        int x = matrix[0].length - 1, y = 0;

        while (x >= 0 && y < matrix.length) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
