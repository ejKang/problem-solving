package com.ps.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum_15 {

    // time complex - o(nlogn) + o(n2) -> o(n2)
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> rst = new HashSet<>();
        int j, k;
        for (int i = 0; i < nums.length; i++) {
            j = i + 1;
            k = nums.length - 1;

            while (k > j) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    // rst.add(Arrays.asList(nums[i], nums[j], nums[k]));

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

    public List<List<Integer>> threeSum_2(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> rst = new HashSet<>();
        int target = 0;
        int start = 0, end = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            target = nums[i];

            start = i + 1;
            end = nums.length - 1;

            while (end > start) {
                if (nums[end] + nums[start] + target == 0) {
                    rst.add(Arrays.asList(nums[end], nums[start], target));
                    start++;
                } else if (nums[end] + nums[start] + target > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(rst);
    }
}
