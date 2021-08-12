package com.ps.heap;

import java.util.PriorityQueue;

public class KthSmallest_378 {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        System.out.println(KthSmallest_378.kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int i = matrix[0].length;
        int j = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int y = 0; y < j; y++) {
            for (int z = 0; z < i; z++) {
                queue.add(matrix[y][z]);
            }
        }

        int rst = 0;
        while (k != 0) {
            rst = queue.poll();
            k--;
        }
        return rst;
    }

    public static int kthSmallest_size(int[][] matrix, int k) {
        int i = matrix[0].length;
        int j = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int y = 0; y < j; y++) {
            for (int x = 0; x < i; x++) {
                queue.add(matrix[y][x]);

                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        int rst = queue.poll();
        return rst;
    }
}
