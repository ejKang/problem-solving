package com.ps.tree;

public class UniqueBinarySearchTrees_96 {

    public static void main(String[] args) {
        UniqueBinarySearchTrees_96 u = new UniqueBinarySearchTrees_96();
        System.out.println(u.numTrees(3));
    }

    // dynamic Programming
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int curRoot = 3; curRoot <= n; curRoot++) {
            for (int i = 0; i < curRoot; i++) {
                dp[curRoot] = dp[curRoot] + dp[curRoot - 1 - i] * dp[i];
            }
        }

        return dp[n];
    }
}
