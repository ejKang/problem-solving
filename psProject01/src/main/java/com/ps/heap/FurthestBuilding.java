package com.ps.heap;

import java.util.PriorityQueue;

public class FurthestBuilding {
    
    public static void main(String[] args) {
        int [] heights = {4,2,7,6,9,14,12};
        System.out.println(FurthestBuilding.furthestBuilding(heights, 5, 1));
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i =0; i < heights.length-1; i++) {
            int temp = heights[i+1] - heights[i];
            if (temp < 0) {
                continue;
            }
            queue.add(temp);
            if (queue.size() > ladders) {
                bricks -= queue.poll();
            }
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length-1;
    }
}
