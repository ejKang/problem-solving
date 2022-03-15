package com.ps.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> rst = new HashSet<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtracking(rst, candidates, target, 0, 0, list);
        return new ArrayList<>(rst);
    }

    private void backtracking(Set<List<Integer>> rst, int[] candidates, int target, int tmp, int start,
            List<Integer> list) {

        if (tmp == target) {
            rst.add(new ArrayList<>(list));
            return;
        } else if (tmp > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (tmp + candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            backtracking(rst, candidates, target, tmp + candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
