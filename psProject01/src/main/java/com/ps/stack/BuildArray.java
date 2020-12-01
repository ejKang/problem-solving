package com.ps.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildArray {

    public static void main(String[] args) {
        int[] arr = { 1, 3 };
        List<String> temp = BuildArray.buildArray(arr, 5);
        System.out.println(temp);
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> rst = new ArrayList<>();
        int j = 0;
        for (int i = 1; j < target.length; i++) {
            rst.add("Push");

            if (target[j] == i) {
                j++;
            } else {
                rst.add("Pop");
            }
        }
        return rst;
    }
}
