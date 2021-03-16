package com.ps.array;

public class FindNumbers {
    public int findNumbers(int[] nums) {
        
        int a = 99;

        Integer.toString(a).length();

        int rst = 0;
        for (int i = 0; i< nums.length; i++) {
            int len = Integer.toString(nums[i]).length();

            if (len % 2 == 0) {
                rst++;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int a = 99;
        
        System.out.println(Integer.toString(a).length());
    }
}
