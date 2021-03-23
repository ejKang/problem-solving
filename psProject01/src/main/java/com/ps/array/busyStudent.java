package com.ps.array;

public class busyStudent {
    
    public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {
     
        int rst = 0;
        for (int i = 0; i< startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >=queryTime) {
                rst++;
            }
        }
        return rst;
    }
}
