package com.ps.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqCharInString_387 {

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

            if (map.get(arr[i]) == 1) {
                return i;
            }
        }

        return -1;
    }
}
