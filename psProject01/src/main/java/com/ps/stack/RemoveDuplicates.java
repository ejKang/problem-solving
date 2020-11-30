package com.ps.stack;

import java.util.Stack;

public class RemoveDuplicates {
    
    public static void main(String[] args) {
        String temp = RemoveDuplicates.removeDuplicates("abbcayt");
        System.out.println(temp);
    }
    public static String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();

        for (char c : S.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        return sb.toString();
    }
}
