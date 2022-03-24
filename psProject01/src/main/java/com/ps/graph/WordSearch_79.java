package com.ps.graph;

public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] a = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        WordSearch_79 w = new WordSearch_79();
        w.exist(a, "ABCB");
    }

    public boolean exist(char[][] board, String word) {

        int y = board.length;
        int x = board[0].length;

        boolean rst = false;
        boolean[][] visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                // if (board[i][j] == target) {
                rst = rst | recursive(board, i, j, 0, word, visited);
                // }
            }
        }
        return rst;
    }

    private boolean recursive(char[][] board, int y, int x, int idx, String word, boolean[][] visited) {

        if (idx == word.length()) {
            return true;
        }

        if (x < 0 || x >= board[0].length) {
            return false;
        }
        if (y < 0 || y >= board.length) {
            return false;
        }

        char target = word.charAt(idx);

        boolean rst = false;
        if (board[y][x] == target && !visited[y][x]) {
            visited[y][x] = true;
            rst = rst | recursive(board, y, x + 1, idx + 1, word, visited)
                    | recursive(board, y, x - 1, idx + 1, word, visited)
                    | recursive(board, y - 1, x, idx + 1, word, visited)
                    | recursive(board, y + 1, x, idx + 1, word, visited);
            visited[y][x] = false;
        } else {
            return false;
        }

        return rst;
    }
}
