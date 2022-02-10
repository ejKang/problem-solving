package com.ps.string;

public class ValidPalindrome2_680 {

    public static void main(String[] args) {
        ValidPalindrome2_680 v = new ValidPalindrome2_680();
        // v.validPalindrome("aguok epatg bnvfq mgmlc upuuf xoohd fpgjd mysgv hmvff
        // cnqxj jxqnc ffvmh vgsym djgpf dhoox fuupu culmgm qfvnb gtape kouga");
        v.validPalindrome(
                "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
    }

    // time complexity - o(n)
    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        int valideChange = 1;

        return tt(i, j, valideChange, s);

    }

    private boolean tt(int i, int j, int valideChange, String s) {

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {

                if (valideChange == 0) {
                    return false;
                }

                boolean ib = false, jb = false;
                if (s.charAt(i + 1) == s.charAt(j)) {
                    ib = tt(i + 1, j, valideChange - 1, s);

                }
                if (s.charAt(i) == s.charAt(j - 1) && valideChange > 0) {

                    jb = tt(i, j - 1, valideChange - 1, s);
                }

                valideChange--;
                if (ib || jb) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isAlphabat(char c) {
        return c >= 'a' && c <= 'z';
    }
}
