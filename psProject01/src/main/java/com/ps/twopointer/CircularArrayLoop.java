package com.ps.twopointer;

public class CircularArrayLoop {
    
    public boolean circularArrayLoop(int[] nums) {
        boolean found = false;

        // check all start point
        for (int i = 0; i < nums.length; i++) {
            int slow = i;
            int fast = next(nums, 0, i);
            int direction = nums[slow];

            while (slow != -1 && fast != -1 && slow != fast) {
                slow = next(nums, direction, slow);
                fast = next(nums, direction, next(nums, direction, fast));
            }

            if (slow != -1 && slow == fast) {
                found = true;
                break;
            }
        }
        return found;
    }

    private int next(int[] nums, int direction, int position) {
        if (position == -1) 
            return -1;
        if (direction * nums[position] < 0) 
            return -1;
        int rst = (position + nums[position] ) % nums.length;
        
        if (rst < 0 ) 
            rst += nums.length;
        
        if (rst == position) 
            return -1;
        
        return rst;
    }
}
