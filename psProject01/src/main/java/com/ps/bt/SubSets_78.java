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

    public List<List<Integer>> subsets_3(int[] nums) {

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        bt3(rst, nums, list, 0);
        return rst;
    }

    private void bt3(List<List<Integer>> rst, int[] nums, List<Integer> list, int i) {
        if (i == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        bt3(rst, nums, list, i + 1);

        list.add(nums[i]);
        bt3(rst, nums, list, i + 1);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> subsets_4(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // boolean[] visited = new boolean[nums.length];

        backtraking3(rst, list, nums, 0);
        return rst;
    }

    private void backtraking3(List<List<Integer>> rst, List<Integer> list, int[] nums, int idx) {

        if (idx == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        backtraking3(rst, list, nums, idx + 1);

        list.add(nums[idx]);
        backtraking3(rst, list, nums, idx + 1);
        list.remove(list.size() - 1);

    }

    public List<List<Integer>> subsets_5(int[] nums) {

        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtracking5(rst, list, nums, 0);

        return rst;
    }

    private void backtracking5(List<List<Integer>> rst, List<Integer> tmp, int[] nums, int idx) {

        if (idx == nums.length) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        backtracking5(rst, tmp, nums, idx + 1);

        tmp.add(nums[idx]);
        backtracking5(rst, tmp, nums, idx + 1);
        tmp.remove(tmp.size() - 1);
    }
}
