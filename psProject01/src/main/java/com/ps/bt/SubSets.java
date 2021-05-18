package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        // input = [1, 2, 3]
    	List<List<Integer>> output = new ArrayList<>();
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        bt(output, nums, idx, list);
        return output;
    }

    private void bt(List<List<Integer>> output, int[] nums, int idx, List<Integer> list) {
        int len = nums.length;

        if (idx == len) {
            output.add(new ArrayList<>(list)); // reference copy 
            return;
        }

        bt(output, nums, idx + 1, list);
        
        int c = nums[idx];
        list.add(c);
        bt(output, nums, idx + 1, list);
        int temp = list.size();
        list.remove(temp - 1);
    }
    
    public void bt2(List<List<Integer>> output, int[] nums, int idx, List<Integer> list) {
        output.add(new ArrayList<>(list));
        for (int i = idx ; i<nums.length; i++) {
        	list.add(nums[i]);
        	bt2(output, nums, idx+1, list);
        	list.remove(list.size() -1);
        }
    }
}
