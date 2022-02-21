package com.ps.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        char[] arr = pattern.toCharArray();
        String[] sArr = s.split(" ");

        if (arr.length != sArr.length) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (!pMap.containsKey(c) && !sMap.containsKey(sArr[i])) {
                // Good
                pMap.put(c, sArr[i]);
                sMap.put(sArr[i], c);
            } else if (pMap.containsKey(c) && sMap.containsKey(sArr[i])) {

                if (pMap.get(c).equals(sArr[i]) && sMap.get(sArr[i]).equals(c)) {
                    // Good  
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
