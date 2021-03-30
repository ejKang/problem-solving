package com.ps.dfs;

import com.ps.base.TreeNode;

public class sumEvenGrandParent {
    
    int rst = 0;
    public int sumEvenGrandparent(TreeNode root) {
           
        int rst = 0;
        if (root != null) {
            rst = dfs (root, null, null);
        }

        if (root != null) {
            dfs1 (root, null, null);
        }

        return rst;
    }
    private void dfs1(TreeNode node, TreeNode parent, TreeNode grandParent) {
        
        if (grandParent != null && grandParent.val % 2 == 0) {
            rst += node.val;
        }

        if (node.left != null) {
            dfs (node.left, node, parent);
        }

        if (node.right != null) {
            dfs (node.right, node, parent);
        }
    }

    private int dfs(TreeNode node, TreeNode parent, TreeNode grandParent) {
        
        int rst = 0;
        if (grandParent != null && grandParent.val % 2 == 0) {
            rst += node.val;
        }

        if (node.left != null) {
            rst += dfs (node.left, node, parent);
        }

        if (node.right != null) {
            rst += dfs (node.right, node, parent);
        }

        return rst;
    }
}
