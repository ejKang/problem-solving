package com.ps.array;

public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {

        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, idx);
                idx++;
            }
        }
    }

    private void swap(int[] nums, int i, int idx) {
        int tmp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = tmp;
    }
}
