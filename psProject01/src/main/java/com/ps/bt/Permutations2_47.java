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

    public List<List<Integer>> permuteUnique_2(int[] nums) {

        Set<List<Integer>> rst = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        bt(rst, nums, list, visited);
        List<List<Integer>> r = new ArrayList<>(rst);
        return r;
    }

    private void bt(Set<List<Integer>> rst, int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                bt(rst, nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
