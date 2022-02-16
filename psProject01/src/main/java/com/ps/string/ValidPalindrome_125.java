package com.ps.string;

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        ValidPalindrome_125 a = new ValidPalindrome_125();
        a.isPalindrome_2("race a car");
    }

    // time complexity - o(n)
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

    public boolean isPalindrome_2(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (j > i) {

            if (!isChar(s.charAt(i)) && !isNumber(s.charAt(i))) {
                i++;
                continue;
            }

            if (!isChar(s.charAt(j)) && !isNumber(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
