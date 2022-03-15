package com.ps.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(rst, nums, tmp, used);
        return rst;
    }

    private void backtracking(List<List<Integer>> rst, int[] nums, List<Integer> tmp, boolean[] used) {

        if (tmp.size() == nums.length) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            backtracking(rst, nums, tmp, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        Set<List<Integer>> rst = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking2(rst, nums, tmp, used);
        return new ArrayList<>(rst);
    }

    private void backtracking2(Set<List<Integer>> rst, int[] nums, List<Integer> tmp, boolean[] used) {

        if (tmp.size() == nums.length) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tmp.add(nums[i]);
                used[i] = true;
                backtracking2(rst, nums, tmp, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}
