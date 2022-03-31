package com.ps.bt;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int y = board.length;
        int x = board[0].length;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                backtracking(board, i, j, root, rst);
            }
        }
        return rst;
    }

    private void backtracking(char[][] board, int y, int x, TrieNode p, List<String> rst) {
        char c = board[y][x];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];

        if (p.word != null) {
            rst.add(p.word);
            p.word = null;
        }

        board[y][x] = '#';

        if (y > 0) {
            backtracking(board, y - 1, x, p, rst);
        }

        if (x > 0) {
            backtracking(board, y, x - 1, p, rst);
        }

        if (y < board.length - 1) {
            backtracking(board, y + 1, x, p, rst);
        }

        if (x < board[0].length - 1) {
            backtracking(board, y, x + 1, p, rst);
        }
        board[y][x] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words) {
            TrieNode p = root;
            for (char ch : str.toCharArray()) {
                int i = ch - 'a';

                if (p.next[i] != null) {
                    p.next[i] = new TrieNode();
                }

                p = p.next[i];
            }
            p.word = str;
        }
        return root;
    }

    /**
     * TrieNode
     */
    public class TrieNode {

        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
