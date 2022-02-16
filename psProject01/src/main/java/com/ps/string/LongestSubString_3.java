package com.ps.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString_3 {

    // o(n)
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        while (j < len) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j);
            j++;
        }
        return max;
    }

    // time complexity - o(n2)
    public int lengthOfLongestSubstring_brute_force(String s) {

        char[] arr = s.toCharArray();

        int max = 0;
        int rst = 0;
        for (int i = 0; i < arr.length; i++) {
            max = 0;
            int[] tmp = new int[127];
            for (int j = i; j < arr.length; j++) {
                if (tmp[arr[j]] == 0) {
                    max++;
                    tmp[arr[j]] = 1;
                } else {
                    rst = Math.max(rst, max);
                    break;
                }
            }
            rst = Math.max(rst, max);
        }
        return rst;
    }

    public int lengthOfLongestSubstring_2(String s) {

        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
            } else {
                max = Math.max(max, j - i);
                set.remove(s.charAt(i));
                i++;
            }
        }
        max = Math.max(max, j - i);
        return max;
    }
}
