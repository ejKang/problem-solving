package com.ps.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumberThanCurrent {
    
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        
        int[] rst = new int[nums.length];
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] cloned = nums.clone();
        Arrays.sort(cloned);

        int idx = 0;
        for (int i : cloned)  {
            map.putIfAbsent(i, idx);
            idx++;
        }

        for (int i = 0 ; i < nums.length; i++ ) {
            rst[i] = map.get(nums[i]);
        }
        
        return rst;   
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] rst = new int[nums.length];
        int idx = 0;
        for (int i : nums) {
            int cnt = 0 ;
            for (int j : nums) {
                if (j < i) {
                    cnt++;
                }
            }
            rst[idx] = cnt;
            idx++;
        }
        
        return rst;   
    }
}
