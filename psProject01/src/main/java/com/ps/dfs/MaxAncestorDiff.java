package com.ps.dfs;

import com.ps.base.TreeNode;

public class MaxAncestorDiff {
    
    public int maxAncestorDiff(TreeNode root) {
        
        int rst = 0;
        if (root != null) {
            rst = dfs (root, root.val, root.val, 0);
        }
        return rst;
    }

    private int dfs(TreeNode node, int max, int min, int rst) {

        min = Math.min(node.val, min);
        max = Math.max(node.val, max);

        rst = Math.max(rst, max -min);
        int right = rst;
        if (node.right != null) {
            right = dfs(node.right, max, min,rst);
        }

        int left = rst;
        if (node.left != null) {
            left = dfs (node.left, max, min, rst);
        }

        return Math.max(left, right);
    }
    // int rst = 0;
    // public int maxAncestorDiff(TreeNode root) {
        
    //     if (root != null) {
    //         dfs (root, root.val, root.val);
    //     }
    //     return rst;
    // }
    // private void dfs(TreeNode node, int min, int max) {
    //     min = Math.min(node.val, min);
    //     max = Math.max(node.val, max);

    //     rst = Math.max(rst, max -min);

    //     if (node.right != null) {
    //         dfs(node.right, min, max);
    //     }

    //     if (node.left != null) {
    //         dfs (node.left, min, max);
    //     }
    // }
}
