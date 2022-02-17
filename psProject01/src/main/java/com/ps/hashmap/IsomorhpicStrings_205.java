package com.ps.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorhpicStrings_205 {

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) == t.charAt(i)) {
                    // good
                } else {
                    return false;
                }
            } else {
                if (map.values().contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
            i++;
        }
        return true;
    }

    public boolean isIsomorphic_two_map(String s, String t) {

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        int i = 0;
        while (i < s.length()) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (!mapS.containsKey(charS) && !mapT.containsKey(charT)) {
                // Good
                mapS.put(charS, charT);
                mapT.put(charT, charS);
            } else if (mapS.containsKey(charS) && mapT.containsKey(charT)) {

                if (mapS.get(charS).equals(charT) && mapT.get(charT).equals(charS)) {
                    // Good
                } else {
                    return false;

                }

            } else {
                return false;
            }
            i++;

        }
        return true;
    }
}
