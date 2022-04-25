package com.ps.dp;

import java.util.List;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length() + 1];

        arr[0] = true;

        for (int i = 1; i < s.length(); i++) {
            for (String str : wordDict) {
                if (str.length() <= i) {

                    if (arr[i - str.length()]) {
                        if (s.substring(i - str.length(), i).equals(str)) {
                            arr[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return arr[s.length()];
    }

    public boolean wordBreak_2(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] matches = new boolean[len + 1];
        matches[0] = true;

        for (int i = 1; i < matches.length; i++) {
            for (String word : wordDict) {

                if (i >= word.length()) {

                    if (matches[i - word.length()]) {
                        String tmp = s.substring(i - word.length(), i);
                        if (tmp.equals(word)) {
                            matches[i] = true;
                        }
                    }
                }
            }
        }
        return matches[len];
    }
}
