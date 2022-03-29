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

    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        bt(rst, nums, idx, list);
        return rst;
    }

    private void bt(List<List<Integer>> rst, int[] nums, int idx, List<Integer> list) {

        if (idx == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        bt(rst, nums, idx + 1, list);

        list.add(nums[idx]);
        bt(rst, nums, idx + 1, list);
        list.remove(list.size() - 1);
    }
}
