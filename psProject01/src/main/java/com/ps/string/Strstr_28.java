package com.ps.string;

public class Strstr_28 {

    // time complexity o(n)
    public int strStr(String haystack, String needle) {

        int needleLen = needle.length();

        if (needleLen == 0) {
            return 0;
        }

        String substr = null;
        for (int i = 0; i <= haystack.length() - needleLen; i++) {
            substr = haystack.substring(i, i + needleLen);

            if (substr.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr_2(String haystack, String needle) {

        int power = 1;
        int nHash = 0;
        int hHash = 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

            if (i == 0) {
                for (int j = needle.length() - 1; j >= 0; j--) {
                    nHash = nHash + power * (needle.charAt(j) - 'a');
                    hHash = hHash + power * (haystack.charAt(j) - 'a');

                    if (j != 0) {
                        power *= 2;
                    }

                }
            } else {
                hHash = (hHash - (haystack.charAt(i - 1) - 'a') * power) * 2
                        + (haystack.charAt(i + needle.length() - 1) - 'a');
            }

            if (nHash == hHash) {
                boolean found = true;
                int k = 0;
                for (int j = i; j < i + needle.length(); j++) {
                    if (haystack.charAt(j) != needle.charAt(k)) {
                        found = false;
                        break;
                    }
                    k++;
                }
                if (found) {
                    return i;
                }
            }

        }
        return -1;
    }
}
