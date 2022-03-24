package com.ps.graph;

public class FoodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // boolean[][] visited = new boolean[image.length][image[0].length];

        int oldColor = image[sr][sc];

        // dfs(image, visited, sr, sc, newColor, oldColor);
        if (oldColor != newColor)
            dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int newColor, int oldColor) {
        int height = image.length;
        int weight = image[0].length;

        if (i >= 0 && i < height && j >= 0 && j < weight) {

            if (image[i][j] == oldColor) {
                image[i][j] = newColor;

                dfs(image, i + 1, j, newColor, oldColor);
                dfs(image, i, j + 1, newColor, oldColor);
                dfs(image, i - 1, j, newColor, oldColor);
                dfs(image, i, j - 1, newColor, oldColor);
            }

        }

    }

    public void dfs(int[][] image, boolean[][] visited, int i, int j, int newColor, int oldColor) {
        int height = image.length;
        int weight = image[0].length;

        if (i >= 0 && i < height && j >= 0 && j < weight && !visited[i][j]) {
            visited[i][j] = true;

            if (image[i][j] == oldColor) {
                image[i][j] = newColor;

                dfs(image, visited, i + 1, j, newColor, oldColor);
                dfs(image, visited, i, j + 1, newColor, oldColor);
                dfs(image, visited, i - 1, j, newColor, oldColor);
                dfs(image, visited, i, j - 1, newColor, oldColor);
            }

        }

    }

    public static void main(String[] args) {
        FoodFill_733 fill = new FoodFill_733();
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        // image[0]={1,1,1};
        // fill.floodFill(image, 1, 1, 2);
        fill.floodFill_2(image, 1, 1, 2);
    }

    public int[][] floodFill_2(int[][] image, int sr, int sc, int newColor) {
        int y = image.length;
        int x = image[0].length;

        boolean[][] visited = new boolean[y][x];
        int oldColor = image[sr][sc];
        // visited[sr][sc] = true;
        recursive(image, visited, sr, sc, newColor, oldColor);
        // for (int i = 0; i < y; i++) {
        // for (int j = 0; j < x; j++) {

        // }
        // }
        return image;
    }

    private void recursive(int[][] image, boolean[][] visited, int y, int x, int newColor, int oldColor) {

        if (x >= 0 && x < image[0].length && y >= 0 && y < image.length) {

            if (image[y][x] == oldColor && !visited[y][x]) {

                visited[y][x] = true;
                image[y][x] = newColor;

                if (x - 1 >= 0 && x - 1 < image[0].length && y >= 0 && y < image.length && !visited[y][x - 1]) {
                    recursive(image, visited, y, x - 1, newColor, oldColor);
                }

                if (x + 1 >= 0 && x + 1 < image[0].length && y >= 0 && y < image.length && !visited[y][x + 1]) {
                    recursive(image, visited, y, x + 1, newColor, oldColor);
                }

                if (x >= 0 && x < image[0].length && y + 1 >= 0 && y + 1 < image.length && !visited[y + 1][x]) {
                    recursive(image, visited, y + 1, x, newColor, oldColor);
                }

                if (x >= 0 && x < image[0].length && y - 1 >= 0 && y - 1 < image.length && !visited[y - 1][x]) {
                    recursive(image, visited, y - 1, x, newColor, oldColor);
                }
            }
        }
    }
}
