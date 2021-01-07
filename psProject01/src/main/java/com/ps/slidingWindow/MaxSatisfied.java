package com.ps.slidingWindow;

public class MaxSatisfied {
    

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int normal = 0, max = 0;
        int unsatisfied = 0;
        for (int i =0 ; i< customers.length; i++) {
            if (grumpy[i] == 0) normal += customers[i];
            else {
                unsatisfied += customers[i];
            }

            if (i>=X) {
                unsatisfied = unsatisfied - grumpy[i-X] * customers[i-X];
            }
            max = Math.max(max, unsatisfied);
        }
        return max + normal;   
    }
}
