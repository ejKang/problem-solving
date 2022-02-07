package com.ps.string;

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        ValidPalindrome_125 a = new ValidPalindrome_125();
        a.isPalindrome("race a car");
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {

            if (!isChar(s.charAt(i)) && !isNumber(s.charAt(i))) {
                i++;
                continue;
            }

            if (!isChar(s.charAt(j)) && !isNumber(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
