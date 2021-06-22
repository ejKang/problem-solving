package com.ps.tree;

import com.ps.base.TreeNode;

public class DiameterOfBT_543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        tree(root);
        return max;
    }

    private int tree(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int right = tree(node.right);
        int left = tree(node.left);

        max = Math.max(right + left, max);

        return Math.max(right, left) + 1;
    }
}
