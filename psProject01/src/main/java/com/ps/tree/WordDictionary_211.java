package com.ps.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordDictionary_211 {

    private boolean isEnd = false;
    Map<String, WordDictionary_211> map = null;

    /** Initialize your data structure here. */
    public WordDictionary_211() {
        this.isEnd = false;
        map = new HashMap<>();
    }

    public void addWord(String word) {
        String str = word.substring(0, 1);

        if (Objects.isNull(map.get(str))) {
            WordDictionary_211 w = new WordDictionary_211();
            map.put(str, w);
        }

        recurAdd(map.get(str), word.substring(1, word.length()));
    }

    private void recurAdd(WordDictionary_211 dictionary, String word) {
        if (word.length() == 0) {
            dictionary.isEnd = true;
            return;
        }

        String str = word.substring(0, 1);

        if (Objects.isNull(dictionary.map.get(str))) {
            WordDictionary_211 w = new WordDictionary_211();
            dictionary.map.put(str, w);
        }

        recurAdd(dictionary.map.get(str), word.substring(1, word.length()));
    }

    public boolean search(String word) {
        String str = word.substring(0, 1);

        if (Objects.isNull(map.get(str))) {
            return false;
        }

        return recurSearch(map.get(str), word.substring(1, word.length()));
    }

    private boolean recurSearch(WordDictionary_211 dictionary, String word) {

        if (word.length() == 0) {
            return dictionary.isEnd;
        }

        String str = word.substring(0, 1);

        if (str.equals(".")) {
            for (String k : dictionary.map.keySet()) {

                if (recurSearch(dictionary.map.get(k), word.substring(1, word.length()))) {
                    return true;
                }
            }
            return false;
        }

        if (Objects.isNull(dictionary.map.get(str))) {
            return false;
        }

        return recurSearch(dictionary.map.get(str), word.substring(1, word.length()));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */
