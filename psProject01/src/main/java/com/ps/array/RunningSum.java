package com.ps.array;

public class RunningSum {

    public static void main(String[] args) {
        System.out.println("ssss");
    }

    public int[] runningSum(int[] nums) {
        int[] rst = new int[nums.length];

        int tmp = 0;
        int idx = 0;
        for (int i : nums) {
            rst[idx] = tmp + i;
            tmp += i;
            idx++;
        }

        return rst;
    }
}
