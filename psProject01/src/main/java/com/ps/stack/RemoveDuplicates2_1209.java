package com.ps.stack;

import java.util.Stack;

public class RemoveDuplicates2_1209 {

    public String removeDuplicates(String s, int k) {

        Stack<Character> stack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (stack.isEmpty()) {
                stack.push(c);
                cntStack.push(1);
            } else {

                if (c == stack.peek()) {
                    if (cntStack.peek() == k - 1) {
                        int tmp = k - 1;
                        while (tmp > 0) {
                            stack.pop();
                            cntStack.pop();
                            tmp--;
                        }
                    } else {
                        stack.push(c);
                        cntStack.push(cntStack.peek() + 1);
                    }
                } else {
                    stack.push(c);
                    cntStack.push(1);
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
