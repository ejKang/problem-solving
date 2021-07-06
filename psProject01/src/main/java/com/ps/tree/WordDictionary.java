package com.ps.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordDictionary { // 211

    boolean isEnd;
    Map<String, WordDictionary> map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.isEnd = false;
        this.map = new HashMap<>();
    }

    public void addWord(String word) {

        if (word.length() == 0) {
            return;
        }
        String str = word.substring(0, 1);
        if (Objects.isNull(map.get(str))) {
            WordDictionary trie = new WordDictionary();
            map.put(str, trie);
        }

        recursiveAdd(map.get(str), word.substring(1, word.length()));
    }

    private void recursiveAdd(WordDictionary trie, String word) {
        if (word.length() == 0) {
            trie.isEnd = true;
            return;
        }
        String str = word.substring(0, 1);
        if (Objects.isNull(trie.map.get(str))) {
            WordDictionary tt = new WordDictionary();
            trie.map.put(str, tt);
        }
        recursiveAdd(trie.map.get(str), word.substring(1, word.length()));
    }

    public boolean search(String word) {

        if (word.length() == 0) {
            return true;
        }

        String str = word.substring(0, 1);

        if (str.equals(".")) {
            for (String tt : map.keySet()) {
                if (recursiveSearch(map.get(tt), word.substring(1, word.length()))) {
                    return true;
                }
            }
            return false;
        }

        if (Objects.isNull(map.get(str))) {
            return false;
        }
        return recursiveSearch(map.get(str), word.substring(1, word.length()));
    }

    private boolean recursiveSearch(WordDictionary trie, String word) {
        if (word.length() == 0) {
            isEnd = trie.isEnd;
            return isEnd;
        }

        String str = word.substring(0, 1);

        if (str.equals(".")) {
            for (String tt : trie.map.keySet()) {
                if (recursiveSearch(trie.map.get(tt), word.substring(1, word.length()))) {
                    return true;
                }
            }
            return false;
        }

        if (Objects.isNull(trie.map.get(str))) {
            return false;
        }
        return recursiveSearch(trie.map.get(str), word.substring(1, word.length()));
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }
}
