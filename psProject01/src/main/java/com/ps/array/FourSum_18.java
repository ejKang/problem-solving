package com.ps.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int k, l;
        Set<List<Integer>> rst = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {
                k = j + 1;
                l = nums.length - 1;

                while (l > k) {
                    System.out.println(i + "," + j + "," + k + "," + l);
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        rst.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        l++;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        l++;
                    } else {
                        k--;
                    }
                }
            }
        }

        List<List<Integer>> t = new ArrayList<>();

        for (List<Integer> s : rst) {
            t.add(s);
        }

        return new ArrayList<>(rst);
    }

}
