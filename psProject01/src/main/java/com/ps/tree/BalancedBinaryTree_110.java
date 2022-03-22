package com.ps.tree;

import com.ps.base.TreeNode;

public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return recursive(root) != -1;
    }

    private int recursive(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int r = recursive(node.right);
        int l = recursive(node.left);

        if (r == -1 || l == -1 || Math.abs(r - l) > 1) {
            return -1;
        }

        return Math.max(r, l) + 1;
    }
}
