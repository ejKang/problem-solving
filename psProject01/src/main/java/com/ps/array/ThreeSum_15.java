package com.ps.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> rst = new HashSet<>();
        int j, k;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;

            while (k > j) {
                System.out.println("i:" + i + " j:" + j + " k:" + k);
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    rst.add(list);
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> l : rst) {
            list.add(l);
        }
        return list;
    }
}
