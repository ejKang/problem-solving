package com.ps.graph;

public class FindTownJudge_997 {
    public static void main(String[] args) {
        FindTownJudge_997 f = new FindTownJudge_997();
        int[][] trust = { { 1, 2 }, { 2, 3 } };
        System.out.println(f.findJudge(3, trust));
    }

    public int findJudge(int n, int[][] trust) {

        int[] indegree = new int[n];

        for (int[] trus : trust) {
            indegree[trus[1] - 1]++;
            indegree[trus[0] - 1]--;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}
