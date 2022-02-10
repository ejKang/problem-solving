package com.ps.array;

public class FindDuplicate_287 {

    public int findDuplicate(int[] nums) {

        // Arrays.sort(nums);

        // for (int i = 0; i < nums.length - 1; i++) {
        // if (nums[i] == nums[i + 1]) {
        // return nums[i];
        // }

        // }

        // time complex - o(n), space complex - o(1)
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]);
            if (nums[tmp] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[tmp] = -nums[tmp];
            }
        }
        return -1;
    }

    public int findDuplicate_2(int[] nums) {

        // Set<Integer> set = new HashSet<>();

        // for (int n : nums) {
        // if (set.contains(n)) {
        // return n;
        // } else {
        // set.add(n);
        // }
        // }
        // return -1;

        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]);

            if (nums[tmp] < 0) {
                return tmp;
            } else {
                nums[tmp] = -nums[tmp];
            }
        }

        return -1;
    }
}
