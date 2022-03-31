package com.ps.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> rst = new HashSet<>();

        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(rst, candidates, tmp, 0, target, 0);
        return new ArrayList<>(rst);
    }

    private void backtracking(Set<List<Integer>> rst, int[] candidates, List<Integer> tmp, int i, int target,
            int start) {

        if (i == target) {
            rst.add(new ArrayList<>(tmp));
            return;
        } else if (i > target) {
            return;
        }

        for (int j = start; j < candidates.length; j++) {
            tmp.add(candidates[j]);
            backtracking(rst, candidates, tmp, i + candidates[j], target, j);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {

        Set<List<Integer>> setRst = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        bt(setRst, candidates, target, list, 0, 0);
        return new ArrayList<>(setRst);
    }

    private void bt(Set<List<Integer>> setRst, int[] candidates, int target, List<Integer> list, int sum,
            int startIdx) {

        if (sum == target) {
            setRst.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            int tmp = candidates[i];
            list.add(tmp);
            bt(setRst, candidates, target, list, sum + tmp, i);
            list.remove(list.size() - 1);
        }

    }
}
