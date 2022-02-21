package com.ps.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.getOrDefault(c, 0) == 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        if (map.keySet().stream().filter(k -> map.get(k) > 0).count() > 0) {
            return false;
        }
        return true;
    }
}
