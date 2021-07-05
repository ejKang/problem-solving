package com.ps.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Trie { // 208, 211

    boolean isEnd;
    Map<String, Trie> map = null;

    /** Initialize your data structure here. */
    public Trie() {
        this.isEnd = false;
        this.map = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        System.out.println(word);
        if (word.length() == 0) {
            return;
        }
        String str = word.substring(0, 1);
        if (Objects.isNull(map.get(str))) {
            Trie tt = new Trie();
            map.put(str, tt);
        }
        recursiveAdd(map.get(str), word.substring(1, word.length()));

    }

    private void recursiveAdd(Trie trie, String word) {
        System.out.println(word);
        if (word.length() == 0) {
            trie.isEnd = true;
            return;
        }
        String str = word.substring(0, 1);
        if (Objects.isNull(trie.map.get(str))) {
            Trie tt = new Trie();
            trie.map.put(str, tt);
        }
        recursiveAdd(trie.map.get(str), word.substring(1, word.length()));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0) {
            return true;
        }

        String str = word.substring(0, 1);
        System.out.println("search : " + str);
        if (Objects.isNull(map.get(str))) {
            return false;
        }
        return recursiveSearch(map.get(str), word.substring(1, word.length()));
    }

    private boolean recursiveSearch(Trie trie, String word) {
        if (word.length() == 0) {
            isEnd = trie.isEnd;
            return isEnd;
        }
        String str = word.substring(0, 1);
        System.out.println("search recur: " + str);
        if (Objects.isNull(trie.map.get(str))) {
            return false;
        }

        return recursiveSearch(trie.map.get(str), word.substring(1, word.length()));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }

        String str = prefix.substring(0, 1);
        if (Objects.isNull(map.get(str))) {
            return false;
        }
        return recursiveStartsWith(map.get(str), prefix.substring(1, prefix.length()));
    }

    private boolean recursiveStartsWith(Trie trie, String word) {
        if (word.length() == 0) {
            return true;
        }
        String str = word.substring(0, 1);

        if (Objects.isNull(trie.map.get(str))) {
            return false;
        }

        return recursiveStartsWith(trie.map.get(str), word.substring(1, word.length()));
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple"); // return True
        trie.search("app"); // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app"); // return True
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
