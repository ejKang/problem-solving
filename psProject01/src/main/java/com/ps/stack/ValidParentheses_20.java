package com.ps.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 { // 1249

    public static void main(String[] args) {
        ValidParentheses_20 v = new ValidParentheses_20();

        v.isValid("{}[]()");
    }

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {

                if (stack.empty()) {
                    return false;
                }

                if (stack.peek() == map.get(s.charAt(i))) {
                    // valid
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
