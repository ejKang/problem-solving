package com.ps.array;

import java.util.ArrayList;
import java.util.List;

public class CreateTargerArr {
    
    public int[] createTargetArray(int[] nums, int[] index) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i< nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] rst = list.stream().mapToInt(i -> i).toArray();
        return rst;
    }
}
