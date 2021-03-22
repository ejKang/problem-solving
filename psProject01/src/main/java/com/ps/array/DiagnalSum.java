package com.ps.array;

public class DiagnalSum {
    public int diagonalSum(int[][] mat) {
        
        int len = mat.length;
        boolean isEven = ((len % 2) == 0)?true : false;
        int rst = 0 ; 
        int target = 0;
        if (isEven) {
            target = len / 2 -1;
        } else {
            target = len / 2 ;
        }
        for (int i = 0; i< mat.length; i++) {

            if ( i == target) {
                if (isEven) {
                    rst += (mat[i][i] + mat[i][len-1-i]);  
                } else {
                    rst += mat[i][i];
                }
            } else {
                rst += (mat[i][i] + mat[i][len-1-i]);
            }
        }


        return rst;
    }
}
