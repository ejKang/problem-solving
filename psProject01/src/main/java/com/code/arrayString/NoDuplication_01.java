package com.code.arrayString;

import java.util.Arrays;

public class NoDuplication_01 {

    // time complexity - o(nlogn), space - 0(1)
    public boolean noDupl(String s) {
        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean isUniqueChar(String s) {

        if (s.length() > 128) { // size's of ascii is 128 !
            return false;
        }
        boolean[] arr = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)]) {
                return false;
            }
            arr[s.charAt(i)] = true;
        }
        return true;
    }

    public boolean isUniqueChar_bit_oper(String s) {
        int checker = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';

            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker = checker | (1 << val);

        }
        return true;
    }
}
