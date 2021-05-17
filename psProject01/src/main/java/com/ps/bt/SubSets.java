package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] args) {
        SubSets ss = new SubSets();
        int[] sss = { 1, 2, 3 };
        List<List<Integer>> tt = ss.subsets(sss);
        tt.toString();
        for (List<Integer> ff : ss.output) {
            System.out.println(ff.toString());
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        // input = [1, 2, 3]

        int idx = 0;
        List<Integer> list = new ArrayList<>();
        bt(nums, idx, list);
        return null;
    }

    private void bt(int[] nums, int idx, List<Integer> list) {
        int len = nums.length;

        if (idx == len) {

            output.add(new ArrayList<>(list));
            return;
        }

        int c = nums[idx];

        bt(nums, idx + 1, list);
        list.add(c);
        bt(nums, idx + 1, list);
        int temp = list.size();
        list.remove(temp - 1);
    }
}
