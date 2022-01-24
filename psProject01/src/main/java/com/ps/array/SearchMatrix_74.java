package com.ps.array;

public class SearchMatrix_74 {

    public static void main(String[] args) {
        SearchMatrix_74 s = new SearchMatrix_74();
        int[][] a = new int[1][1];
        a[0][0] = 1;
        s.searchMatrix(a, 0);
    }

    // time complexity - o(logm+n)
    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0, j = matrix.length - 1;

        while (i <= j) {

            if (matrix[i][0] < target) {
                i++;
            } else if (matrix[i][0] == target) {
                return true;
            } else {
                j--;
            }
        }
        int k = j;

        if (k < 0) {
            return false;
        }
        i = 0;
        j = matrix[0].length - 1;

        while (i <= j) {
            if (matrix[k][i] < target) {
                i++;
            } else if (matrix[k][i] == target) {
                return true;
            } else {
                j--;
            }
        }
        return false;
    }
}
