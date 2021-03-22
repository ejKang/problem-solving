package com.ps.array;

public class FlipAndInvertImage {
    
    public int[][] flipAndInvertImage(int[][] image) {
        
        int len = image[0].length;
        boolean isEven = ((len % 2) == 0)? true : false;
        int half = len / 2;
        for (int i = 0; i < image.length; i++) {

            for (int j = 0; j <image[0].length; j++) {

                if (half > j) {
                    int temp = image[i][j];
                    image[i][j] = image[i][len - j-1] ;
                    image[i][len - j-1]  = temp;
                }
            }

            for (int j = 0; j <image[0].length; j++) {

                if (image[i][j] == 1) {
                    image[i][j] = 0;
                } else {
                    image[i][j] = 1;
                }
            }
        }

        return image;
    }
}
