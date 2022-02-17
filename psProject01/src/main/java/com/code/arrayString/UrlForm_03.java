package com.code.arrayString;

import java.util.HashSet;
import java.util.Set;

public class UrlForm_03 {

    public String urlForm(String s) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                set.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (set.contains(i)) {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public void replaceSpaces(char[] str, int len) {
        int spaceCnt = 0;

        for (char c : str) {
            if (c == ' ') {
                spaceCnt++;
            }
        }

        int rstLen = len + spaceCnt * 2;
        if (len < str.length) {
            str[len] = '\0';
        }

        for (int i = len - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[rstLen - 3] = '%';
                str[rstLen - 2] = '2';
                str[rstLen - 1] = '0';
                rstLen -= 3;
            } else {
                str[rstLen - 1] = str[i];
                rstLen -= 1;
            }
        }
    }
}
