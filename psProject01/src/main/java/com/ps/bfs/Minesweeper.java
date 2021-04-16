package com.ps.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Minesweeper {

    int[] dx = new int[] { 0, -1, 0, 1, 1, -1, 1, -1 };
    int[] dy = new int[] { 1, 0, -1, 0, 1, -1, -1, 1 };

    public char[][] updateBoard(char[][] board, int[] click) {

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        queue.offer(click);
        visited[click[0]][click[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int mines = getNumberOfMines(board, x, y);

            if (mines == 0) {
                board[x][y] = 'B';

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && !visited[nx][ny]) {
                        queue.offer(new int[] { nx, ny });
                        visited[nx][ny] = true;
                    }
                }
            } else {
                board[x][y] = (char) (mines + '0');
            }
        }

        return board;
    }

    private int getNumberOfMines(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length) {
                cnt += board[nx][ny] == 'M' ? 1 : 0;
            }
        }
        return cnt;
    }
}
