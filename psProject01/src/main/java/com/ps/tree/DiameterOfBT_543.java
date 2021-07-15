package com.ps.tree;

import java.util.Objects;

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

    public int diameterOfBinaryTree_2(TreeNode root) {

        int rootMaxDept = diaTree(root);
        System.out.println(rootMaxDept);
        return max;
    }

    private int diaTree(TreeNode node) {

        if (Objects.isNull(node)) {
            return 0;
        }

        int right = diaTree(node.right);
        int left = diaTree(node.left);

        max = Math.max(max, right + left);

        return Math.max(right, left) + 1;
    }
}
