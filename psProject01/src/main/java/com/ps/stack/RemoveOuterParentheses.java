package com.ps.stack;

public class RemoveOuterParentheses {

    public static void main(String[] args) {
        String aa = RemoveOuterParentheses.removeOuterParentheses("(()())(())");
        System.out.println(aa);
    }
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) sb.append(c);
            if (c == ')' && opened-- > 1) sb.append(c);
        }
        return sb.toString();
    }

    
    public static String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' ) {
                if (opened != 0) {
                    sb.append(c);
                }
                opened --;
            }
            if (c == ')' ) {
                opened ++;

                if (opened != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
