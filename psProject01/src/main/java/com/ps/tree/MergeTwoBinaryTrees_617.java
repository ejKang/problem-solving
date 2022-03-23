package com.ps.tree;

import com.ps.base.TreeNode;

public class MergeTwoBinaryTrees_617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        TreeNode newTree = new TreeNode(val);
        newTree.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newTree.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newTree;
    }

    public TreeNode mergeTrees_2(TreeNode root1, TreeNode root2) {

        TreeNode node = new TreeNode();

        if (root1 == null && root2 == null) {
            return null;
        } else {
            int sum = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
            node.val = sum;
            node.left = mergeTrees_2(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
            node.right = mergeTrees_2(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        }
        return node;
    }
}
