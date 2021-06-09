package com.ps.bt;

public class WordSearch {
    public static boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        boolean rst = false;
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                if ((word.charAt(0) == board[i][j]) && backtracking(board, word, i, j, 0)) {
                    return true;
                }

            }
        }

        return rst;
    }

    private boolean backtracking(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
                || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (backtracking(board, word, i - 1, j, index + 1) || backtracking(board, word, i + 1, j, index + 1)
                || backtracking(board, word, i, j - 1, index + 1) || backtracking(board, word, i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        // String t = "ABCB"; // false
        // String t = "ABCCED"; // true
        String t = "SEE"; // true
        char[][] ww = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        System.out.println(w.exist1(ww, t));

    }

    public boolean exist1(char[][] board, String word) {

        char start = word.charAt(0);
        boolean[][] visited1 = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == start) {
                    if (bt(board, i, j, word, 0, visited1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bt(char[][] board, int y, int x, String word, int idx, boolean[][] visited1) {

        if (idx == word.length()) {
            return true;
        }

        int i = board.length;
        int j = board[0].length;
        if (x < 0 || x >= j) {
            return false;
        }
        if (y < 0 || y >= i) {
            return false;
        }

        if (visited1[y][x]) {
            return false;
        }

        if (word.charAt(idx) == board[y][x]) {
            visited1[y][x] = true;

            boolean rst = bt(board, y - 1, x, word, idx + 1, visited1) || bt(board, y + 1, x, word, idx + 1, visited1)
                    || bt(board, y, x - 1, word, idx + 1, visited1) || bt(board, y, x + 1, word, idx + 1, visited1);

            if (!rst) {
                visited1[y][x] = false;
            } else {
                return true;
            }
        }

        return false;
    }
}
