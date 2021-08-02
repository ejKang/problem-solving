package com.ps.graph;

public class FoodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        boolean[][] visited = new boolean[image.length][image[0].length];

        int oldColor = image[sr][sc];
        // image[sr][sc] = newColor;
        dfs(image, visited, sr, sc, newColor, oldColor);
        return image;
    }

    private void dfs(int[][] image, boolean[][] visited, int i, int j, int newColor, int oldColor) {
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
}
