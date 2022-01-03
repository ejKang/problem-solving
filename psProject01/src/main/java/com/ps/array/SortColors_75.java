package com.ps.array;

public class SortColors_75 {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        int p = 0;

        while (j >= p) {
            if (nums[p] == 0) {
                swap(i, p, nums);
                i++;
                p++;
            } else if (nums[p] == 2) {
                swap(j, p, nums);
                j--;
            } else {
                p++;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
