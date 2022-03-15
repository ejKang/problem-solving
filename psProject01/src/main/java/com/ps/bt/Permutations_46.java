package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        backtracking(rst, nums, new ArrayList<>());
        return rst;
    }

    private void backtracking(List<List<Integer>> rst, int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            rst.add(new ArrayList<>(tmp));
            return;
        }

        for (int num : nums) {
            if (tmp.contains(num)) {
                continue;
            }

            tmp.add(num);
            backtracking(rst, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
