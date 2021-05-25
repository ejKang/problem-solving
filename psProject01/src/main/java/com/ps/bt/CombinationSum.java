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
        return null;
    }

    private void bt(List<List<Integer>> rst, List<Integer> list, int target, List<Integer> candidates) {
        int t = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("t" + t);
        if (t == target) {
            rst.add(new ArrayList<>(list));
        } else if (t > target) {
            // do nothings
        } else {

            for (int i : candidates) {
                List<Integer> tt = candidates.stream().filter(can -> can >= i).collect(Collectors.toList());
                System.out.println("tt" + tt.toString());
                int temp = target - i;
                list.add(i);
                bt(rst, list, temp, tt);
                list.remove(list.size() - 1);
            }
        }
    }
}
