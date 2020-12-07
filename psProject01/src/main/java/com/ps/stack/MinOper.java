package com.ps.stack;

import java.util.Stack;

public class MinOper {
    
    public static void main(String[] args) {
        String logs[] = {"../", "./", "d/", "df", "../"};
        MinOper.minOperations(logs);
    }

    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String str : logs) {
            switch (str) {
                case "../":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "./":
                    break;
                default:
                    stack.push(str);
            }
        }
        int s = stack.size();
        System.out.println(s);
        return s;
    }
}
