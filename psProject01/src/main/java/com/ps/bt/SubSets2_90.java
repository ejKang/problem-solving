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
}
