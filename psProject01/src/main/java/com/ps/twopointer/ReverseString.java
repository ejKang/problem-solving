package com.ps.twopointer;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'a','f','g','p','w','y'};
        ReverseString.reverseString(s);
    }

    public static void reverseString(char[] s) {
        int len = s.length - 1, i = 0;

        while(len > i ) {
            switchChar(s, len, i);
            len--;
            i++;
        }
    }

    private static void switchChar(char[] s, int len, int i) {
        char temp = s[i];
        s[i] = s[len];
        s[len] = temp;
    }
}
