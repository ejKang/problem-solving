package com.ps.tree;

import java.util.HashMap;
import java.util.Map;

public class Trie_208 {

    boolean isEnd;
    Map<String, Trie_208> map;

    public Trie_208() {
        this.isEnd = false;
        this.map = new HashMap<>();
    }

    public void insert(String word) {

        if (word == null || word.length() == 0) {
            return;
        }

        String sub = word.substring(0, 1);
        if (this.map.containsKey(sub)) {

        } else {
            Trie_208 trie = new Trie_208();
            this.map.put(sub, trie);
        }
        recursiveInsert(this.map.get(sub), word.substring(1));
    }

    private void recursiveInsert(Trie_208 trie, String word) {

        if (word == null || word.length() == 0) {
            trie.isEnd = true;
            return;
        }
        String sub = word.substring(0, 1);
        if (trie.map.containsKey(sub)) {
        } else {
            Trie_208 tt = new Trie_208();
            trie.map.put(sub, tt);
        }
        recursiveInsert(trie.map.get(sub), word.substring(1));
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        String sub = word.substring(0, 1);
        if (!this.map.containsKey(sub)) {
            return false;
        }

        return recursiveSearch(this.map.get(sub), word.substring(1));
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        String sub = prefix.substring(0, 1);
        if (!this.map.containsKey(sub)) {
            return false;
        }
        return recursiveStartWith(this.map.get(sub), prefix.substring(1));
    }

    private boolean recursiveSearch(Trie_208 trie, String word) {
        if (word == null || word.length() == 0) {
            return trie.isEnd;
        }

        String sub = word.substring(0, 1);
        if (!trie.map.containsKey(sub)) {
            return false;
        }

        return recursiveSearch(trie.map.get(sub), word.substring(1));
    }

    private boolean recursiveStartWith(Trie_208 trie, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        String sub = word.substring(0, 1);
        if (!trie.map.containsKey(sub)) {
            return false;
        }
        return recursiveStartWith(trie.map.get(sub), word.substring(1));
    }
}
