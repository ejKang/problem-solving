package com.ps.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            // String tmp = new String(arr);
            String tmp = String.valueOf(arr);

            map.putIfAbsent(tmp, new ArrayList<>());
            // if (!map.containsKey(tmp)) {
            // map.put(tmp, new ArrayList<>());
            // }

            map.get(tmp).add(str);
        }

        // List<List<String>> rst = new ArrayList<>();
        // rst.addAll(map.values());
        // return rst;

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_no_sorting(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        int[] cntArr = null;

        for (String str : strs) {
            cntArr = new int[26];

            // make table
            for (char c : str.toCharArray()) {
                cntArr[c - 'a'] = cntArr[c - 'a'] + 1;
            }

            // make key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cntArr.length; i++) {
                if (cntArr[i] != 0) {
                    sb.append('a' + i).append(cntArr[i]);
                }
            }

            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
