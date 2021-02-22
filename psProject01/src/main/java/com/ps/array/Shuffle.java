package com.ps.array;

public class Shuffle {
    
    public static void main(String[] args) {
        Shuffle a = new Shuffle();
        int[] b = {1,2,3,4,5,6};

        int[] rs = a.shuffle(b, 3);
        for (int i :rs ) {
            System.out.println(i);
        }
        System.out.println(rs.toString());
    }

    public int[] shuffle(int[] nums, int n) {
        int idx = 0, idx_1 = 1; 

        int [] rst = new int [nums.length];

        for (int i=0; i< n; i++) {
            rst[idx] = nums[i];
            rst[idx+1] = nums[n + i];

            idx+=2;
        }

        return rst;
    }

}
