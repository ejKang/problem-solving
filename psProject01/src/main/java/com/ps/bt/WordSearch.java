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
        // String t = "ABCB";
        // String t = "ABCCED";
        String t = "SEE";
        char[][] ww = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        System.out.println(w.exist(ww, t));

    }
}
