package com.ps.string;

public class Strstr_28 {

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
}
