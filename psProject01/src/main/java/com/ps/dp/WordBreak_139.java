package com.ps.dp;

import java.util.List;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length() + 1];

        arr[0] = true;

        for (int i = 1; i < +s.length(); i++) {
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
}
