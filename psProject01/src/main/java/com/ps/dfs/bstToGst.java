package com.ps.dfs;

import com.ps.base.TreeNode;

public class bstToGst {
    
    int sum = 0;
    public TreeNode bstToGst1(TreeNode root) {
        
        if (root != null) {
            dfs(root);
        }

        return root;
    }

    private void dfs(TreeNode node) {
        if (node.right != null) {
            dfs (node.right);
        }
        int temp = node.val;
        node.val = sum + temp;
        sum = node.val;

        if (node.left != null) {
            dfs(node.left);
        }
    }
}
