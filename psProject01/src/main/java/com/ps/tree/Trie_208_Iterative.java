package com.ps.tree;

import java.util.HashMap;
import java.util.Map;

public class Trie_208_Iterative {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(2, 3));
    }

    boolean isEnd;
    Map<String, Trie_208_Iterative> map;

    public Trie_208_Iterative() {
        this.isEnd = false;
        this.map = new HashMap<>();
    }

    public void insert(String word) {

        if (word == null || word.length() == 0) {
            return;
        }

        Trie_208_Iterative tmp = this;
        for (int i = 0; i < word.length(); i++) {
            String str = word.substring(i, i + 1);
            if (!tmp.map.containsKey(str)) {
                Trie_208_Iterative trie = new Trie_208_Iterative();
                tmp.map.put(str, trie);
            }
            tmp = tmp.map.get(str);
        }
        tmp.isEnd = true;
    }

    public boolean search(String word) {

        if (word == null || word.length() == 0) {
            return true;
        }
        Trie_208_Iterative tmp = this;
        for (int i = 0; i < word.length(); i++) {
            String str = word.substring(i, i + 1);
            if (!tmp.map.containsKey(str)) {
                return false;
            } else {
                tmp = tmp.map.get(str);
            }
        }

        return tmp.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        Trie_208_Iterative tmp = this;
        for (int i = 0; i < prefix.length(); i++) {
            String str = prefix.substring(i, i + 1);
            if (!tmp.map.containsKey(str)) {
                return false;
            } else {
                tmp = tmp.map.get(str);
            }
        }
        return true;
    }
}
