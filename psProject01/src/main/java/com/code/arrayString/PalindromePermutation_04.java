package com.code.arrayString;

import java.util.Arrays;

public class PalindromePermutation_04 {

    public boolean palindromePermutation(String str) {

        str = str.replaceAll(" ", "");

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        int lastChance = 1;

        int i = 0;
        while (i < arr.length - 1) {

            if (arr[i] == arr[i + 1]) {
                i += 2;
            } else {
                if (lastChance == 0) {
                    return false;
                } else {
                    lastChance--;
                    i++;
                }
            }
        }
        return true;
    }

    // time complexity - o(n)
    public boolean isPermutationOfPalindrome(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNum(c);
            if (x != -1) {
                table[x]++;
            }
        }

        boolean foundOdd = false;
        for (int cnt : table) {
            if (cnt % 2 == 1) {
                if (foundOdd) {
                    return false;
                } else {
                    foundOdd = true;
                }
            }
        }
        return true;
    }

    private int getCharNum(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (val >= a && val <= z) {
            return val - a;
        }
        return -1;
    }
}
