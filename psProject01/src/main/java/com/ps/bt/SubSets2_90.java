package com.ps.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);

        backtracking(rst, nums, 0, tmp);
        return rst;
    }

    private void backtracking(List<List<Integer>> rst, int[] nums, int start, List<Integer> tmp) {
        rst.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { // duplicated case
                continue;
            }

            tmp.add(nums[i]);
            backtracking(rst, nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup_2(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        backtracking2(rst, list, nums, 0);
        return rst;
    }

    private void backtracking2(List<List<Integer>> rst, List<Integer> list, int[] nums, int idx) {

        rst.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            if (i == idx || nums[i-1] != nums[i]) {
                list.add(nums[i]);
                backtracking2(rst, list, nums, i+1);
                list.remove(list.size()-1);
            } 
        }
    }

}
