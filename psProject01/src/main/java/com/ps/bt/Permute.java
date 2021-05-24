package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        bt(rst, new ArrayList<>(), nums);
        return rst;
    }

    private void bt(List<List<Integer>> rst, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (list.contains(num)) {
                    continue;
                }
                list.add(num);
                bt(rst, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
