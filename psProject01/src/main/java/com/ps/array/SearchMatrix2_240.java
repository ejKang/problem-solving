package com.ps.array;

public class SearchMatrix2_240 {

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
}
