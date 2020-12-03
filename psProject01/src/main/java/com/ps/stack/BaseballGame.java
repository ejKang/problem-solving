package com.ps.stack;

import java.util.Stack;

public class BaseballGame {
    
    public static void main(String[] args) {
        String[] ops = {"4", "3", "+", "D"};
        System.out.println(BaseballGame.calPoints(ops));
    }
    public static int calPoints(String[] ops) {
        
        Stack<Integer> stack = new Stack<>();

        for (String str : ops) {

            if (str.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.peek();
                stack.push(temp1);
                stack.push(temp1 + temp2);
            } else if (str.equals("D")) {
                int temp = stack.peek();
                stack.push(temp * 2);
            } else if (str.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int total = 0; 
        for (int i : stack) {
            total += i;
        }
        return total;
    }
}
