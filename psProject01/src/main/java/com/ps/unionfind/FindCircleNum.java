package com.ps.unionfind;

public class FindCircleNum {
    
    public static void main(String[] args) {
        int [][] M =  {{ 1,  1,  0}, {1, 1, 0},{0, 0, 1}};
        System.out.println(FindCircleNum.findCircleNum(M));    
    }

    public static int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length]; // default value is false
        int cnt = 0;

        for (int i = 0; i< M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i );
                cnt++;
            }
        }

        return cnt;
    }

    private static void dfs(int[][] M, boolean[] visited, int person) {
        for (int other = 0; other < M.length; other++) {
            if (M[person][other] == 1 && !visited[other]) {
                visited[other] = true;
                dfs(M, visited, other);
            }
        }
    }
}
