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

    public int findJudge_2(int n, int[][] trust) {
        boolean[] notJudge = new boolean[n];
        int[] cntArr = new int[n];

        for (int[] tr : trust) {
            notJudge[tr[0] - 1] = true;
            cntArr[tr[1] - 1] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (!notJudge[i] && cntArr[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
