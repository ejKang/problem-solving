package com.ps.stack;

import java.util.Stack;

public class MakeGood {
    
    public static void main(String[] args) {
        System.out.println(MakeGood.makeGood("leeEeitcode"));
    }
    public static String makeGood(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char temp = stack.peek();
                if (temp == c+32 || temp == c -32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        String rst = "";
        for (char c : stack) {
            rst = rst + c ;
        }
        return rst;
    }
}
