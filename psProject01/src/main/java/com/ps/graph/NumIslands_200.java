package com.ps.graph;

import java.util.Stack;

public class NumIslands_200 {

    public int numIslands(char[][] grid) {

        int rst = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, visited, i, j);
                    rst++;
                }
            }
        }
        return rst;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int width = grid[0].length;
        int height = grid.length;

        if (i + 1 >= 0 && i + 1 < height && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            dfs(grid, visited, i + 1, j);
        }

        if (j + 1 >= 0 && j + 1 < width && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            dfs(grid, visited, i, j + 1);
        }

        if (i - 1 >= 0 && i - 1 < height && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            dfs(grid, visited, i - 1, j);
        }

        if (j - 1 >= 0 && j - 1 < width && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            dfs(grid, visited, i, j - 1);
        }

    }

    public static void main(String[] args) {
        char[][] a = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        NumIslands_200 n = new NumIslands_200();
        System.out.println(n.numIslands_2(a));
    }

    public int numIslands_2(char[][] grid) {

        int y = grid.length;
        int x = grid[0].length;

        boolean[][] visited = new boolean[y][x];

        int cnt = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    visited[i][j] = true;
                    recursiveVisit(i, j, grid, visited);
                }
            }
        }
        return cnt;
    }

    private void recursiveVisit(int y, int x, char[][] grid, boolean[][] visited) {

        if (x - 1 >= 0 && grid[y][x - 1] == '1' && !visited[y][x - 1]) {
            visited[y][x - 1] = true;
            recursiveVisit(y, x - 1, grid, visited);
        }
        if (x + 1 < grid[0].length && grid[y][x + 1] == '1' && !visited[y][x + 1]) {
            visited[y][x + 1] = true;
            recursiveVisit(y, x + 1, grid, visited);
        }

        if (y - 1 >= 0 && grid[y - 1][x] == '1' && !visited[y - 1][x]) {
            visited[y - 1][x] = true;
            recursiveVisit(y - 1, x, grid, visited);
        }
        if (y + 1 < grid.length && grid[y + 1][x] == '1' && !visited[y + 1][x]) {
            visited[y + 1][x] = true;
            recursiveVisit(y + 1, x, grid, visited);
        }
    }

    public int numIslands_2_iteration(char[][] grid) {

        int y = grid.length;
        int x = grid[0].length;

        boolean[][] visited = new boolean[y][x];

        int cnt = 0;
        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;

                    Integer[] arr = new Integer[2];
                    arr[0] = i;
                    arr[1] = j;
                    stack.push(arr);

                    while (!stack.isEmpty()) {
                        Integer[] tmp = stack.pop();

                        int xx = tmp[1];
                        int yy = tmp[0];

                        visited[yy][xx] = true;

                        if (xx - 1 >= 0 && grid[yy][xx - 1] == '1' && !visited[yy][xx - 1]) {
                            Integer[] ss = new Integer[2];
                            ss[0] = yy;
                            ss[1] = xx - 1;
                            stack.push(ss);
                        }
                        if (xx + 1 < grid[0].length && grid[yy][xx + 1] == '1' && !visited[yy][xx + 1]) {
                            Integer[] ss = new Integer[2];
                            ss[0] = yy;
                            ss[1] = xx + 1;
                            stack.push(ss);
                        }

                        if (yy - 1 >= 0 && grid[yy - 1][xx] == '1' && !visited[yy - 1][xx]) {
                            Integer[] ss = new Integer[2];
                            ss[0] = yy - 1;
                            ss[1] = xx;
                            stack.push(ss);
                        }
                        if (yy + 1 < grid.length && grid[yy + 1][xx] == '1' && !visited[yy + 1][xx]) {
                            Integer[] ss = new Integer[2];
                            ss[0] = yy + 1;
                            ss[1] = xx;
                            stack.push(ss);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
