package com.code.arrayString;

import java.util.Arrays;

public class CheckPermutation_02 {

    public boolean checkPermut(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < arrA.length; i++) {

            if (arrA[i] != arrB[i]) {
                return false;
            }
        }

        // a = new String(arrA);
        // b = new String(arrB);

        // boolean rst = a.equals(b);
        return true;
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[128];

        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i);

            arr[tmp]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int tmp = t.charAt(i);

            arr[tmp]--;

            if (arr[tmp] < 0) {
                return false;
            }
        }

        return true;
    }
}
