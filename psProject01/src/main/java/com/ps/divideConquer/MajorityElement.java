package com.ps.divideConquer;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    
    public static void main(String[] args) {

        int[] nums = {2,3,2,1,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 0) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
        }

        int temp = nums.length / 2 ;
        for (int key :map.keySet()) {
            if (map.get(key) > temp)   {
                return key;
            }
        }

        return -1;
    }
}
