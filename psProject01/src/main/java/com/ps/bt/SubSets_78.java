package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class SubSets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        int len = nums.length;
        backtracking(0, len, nums, rst, new ArrayList<>());
        return rst;
    }

    private void backtracking(int i, int end, int[] nums, List<List<Integer>> rst, List<Integer> tmp) {

        if (i == end) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        backtracking(i + 1, end, nums, rst, tmp);

        tmp.add(nums[i]);
        backtracking(i + 1, end, nums, rst, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
