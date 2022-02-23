package com.ps.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// related topic : heap
public class TopKFrequentWords_692 {
    public static void main(String[] args) {
        TopKFrequentWords_692 t = new TopKFrequentWords_692();
        // String[] s = { "the", "day", "is", "sunny", "the", "the", "the", "sunny",
        // "is", "is" };
        String[] s = { "i", "love", "leetcode", "i", "love", "coding" };

        t.topKFrequent(s, 4);
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Arrays.sort(words, (a, b) -> a.compareTo(b));
        Arrays.sort(words, (a, b) -> map.get(b) - map.get(a));

        List<String> rst = new ArrayList<>();

        int i = 0;
        while (rst.size() < k) {
            if (!rst.contains(words[i])) {
                rst.add(words[i]);
            }
            i++;
        }
        return rst;
    }

    public List<String> topKFrequent_entrySet(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {

                if (a.getValue() < b.getValue()) {
                    return 1;
                } else if (a.getValue() > b.getValue()) {
                    return -1;
                } else {
                    return a.getKey().compareTo(b.getKey());
                }
            }
        });

        List<String> rst = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : list) {
            if (k-- > 0) {
                rst.add(entry.getKey());
            }

        }
        return rst;
    }

    public List<String> topKFrequent_map_sort(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> rst1 = map.entrySet().stream().sorted((a, b) -> {
            if (a.getValue() != b.getValue()) {
                return b.getValue() - a.getValue();
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        }).map(m -> m.getKey()).limit(k).collect(Collectors.toList());

        return rst1;
    }
}
