package com.ps.bt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();

        List<Integer> candi = new ArrayList<>();
        for (int i : candidates) {
            candi.add(i);
        }
        Collections.sort(candi);
        bt(rst, new ArrayList<>(), target, candi);

        bt2(rst, new ArrayList<>(), candidates, target, 0);
        return rst;
    }

    private void bt2(List<List<Integer>> rst, List<Integer> list, int[] nums, int remain, int startIdx) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            rst.add(new ArrayList<>(list));
        } else {
            for (int i = startIdx; i < nums.length; i++) {
                int temp = remain - nums[i];
                list.add(nums[i]);
                bt2(rst, list, nums, temp, i);
                list.remove(list.size() - 1);
            }
        }

    }

    private void bt(List<List<Integer>> rst, List<Integer> list, int target, List<Integer> candidates) {
        if (0 == target) {
            rst.add(new ArrayList<>(list));
        } else {

            for (int i : candidates) {
                if (i > target) {
                    break;
                }
                List<Integer> tt = candidates.stream().filter(can -> can >= i).collect(Collectors.toList());
                int temp = target - i;
                list.add(i);
                bt(rst, list, temp, tt);
                list.remove(list.size() - 1);
            }
        }
    }
}
