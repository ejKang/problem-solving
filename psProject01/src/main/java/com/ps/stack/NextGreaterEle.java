package com.ps.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterEle {
    
    public static void main(String[] args) {
        int[] nums1 = {1 , 3, 2,4}; 
        int[] nums2 = {3, 1, 4, 2, 7};
        System.out.println(NextGreaterEle.nextGreaterElement(nums1, nums2));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {

            while(!stack.isEmpty() && stack.peek() <num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int [] rst = new int[nums1.length];
        int i = 0;
        for (int num : nums1) {
            rst[i] = map.getOrDefault(num, -1);
            i++;
        }
        return rst;   
    }
}
