package com.ps.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays_91 {
    public int numDecodings(String s) {
        Map<String, Integer> map = new HashMap<>();
        int rst = dp(s, map);
        return rst;
    }

    private int dp(String s, Map<String, Integer> map) {

        if (s.startsWith("0")) {
            return 0;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.length() > 2) {
            // String i = s.substring(0, 1);
            int ii = dp(s.substring(1), map);

            String j = s.substring(0, 2);
            int jj = 0;
            if (Integer.valueOf(j) <= 26) {
                jj = dp(s.substring(2), map);
            }
            map.put(s, ii + jj);
            return ii + jj;

        } else if (s.length() == 2) {
            int ii = 0;
            if (!s.contains("0")) {
                ii = 1;
            }
            String j = s.substring(0, 2);
            int jj = 0;
            if (Integer.valueOf(j) <= 26) {
                jj = 1;
            }
            map.put(s, ii + jj);
            return ii + jj;

        } else if (s.length() == 1) {
            map.put(s, 1);
            return 1;
        } else {
            return 0;
        }
    }
}
