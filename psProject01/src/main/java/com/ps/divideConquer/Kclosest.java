package com.ps.divideConquer;

import java.util.PriorityQueue;

public class Kclosest {
    public static void main(String[] args) {
        
    }

    public static int[][] kClosest(int[][] points, int K) {


        // arr[0] = length, arr[1] = index of points
        PriorityQueue<int[]> queue = new PriorityQueue<>(K,(a,b)-> a[0]-b[0]);

        for (int i = 0; i<points.length; i++) {
            int[] arr = points[i];
            int len = arr[0] * arr[0] + arr[1] * arr[1] ;
            queue.add(new int[] {len, i});
        }

        int[][] rst = new int[K][2];
        for (int i=0; i<K; i++) {
            rst[i] = points[queue.poll()[1]];
        }

        return rst;
    }
}
