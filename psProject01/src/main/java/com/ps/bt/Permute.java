package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        Permute per = new Permute();
        int[] a = { 1, 2 };
        List<List<Integer>> list = per.permute(a);

        for (List<Integer> ll : list) {
            System.out.println(ll);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        // bt(rst, new ArrayList<>(), nums);
        backtracking2(rst, nums, new ArrayList<Integer>());
        return rst;
    }

    public void backtracking2(List<List<Integer>> rst, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i : nums) {
            if (!list.contains(i)) {
                list.add(i);
                backtracking2(rst, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public void bt(List<List<Integer>> rst, List<Integer> list, int[] nums) {
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
