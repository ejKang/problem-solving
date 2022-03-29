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

    public int numDecodings_2(String s) {

        Map<String, Integer> map = new HashMap<>();
        int rst = dp_2(s, map);
        return rst;
    }

    private int dp_2(String s, Map<String, Integer> map) {

        if (s.startsWith("0")) {
            return 0;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }

        int len = s.length();

        if (len > 2) {
            int case1 = dp_2(s.substring(1), map);

            String j = s.substring(0, 2);

            int case2 = 0;
            if (Integer.valueOf(j) <= 26) {
                case2 = dp_2(s.substring(2), map);
            }

            map.put(s, case1 + case2);
            return case1 + case2;
        } else if (len == 2) {

            int case1 = 1;
            if (s.contains("0")) {
                case1 = 0;
            }

            int case2 = 1;
            if (Integer.valueOf(s) > 26) {
                case2 = 0;
            }
            map.put(s, case1 + case2);
            return case1 + case2;
        } else if (len == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
