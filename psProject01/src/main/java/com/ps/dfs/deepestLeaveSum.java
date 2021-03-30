package com.ps.dfs;

import com.ps.base.TreeNode;

public class deepestLeaveSum {
    
    int sum = 0;
    int maxLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        int level = 0;

        if (root != null) {
            dfs (root, level);
        }

        return sum;    
    }
    private void dfs(TreeNode node, int level) {

        if (level  > maxLevel) {
            sum = 0;
            maxLevel = level;
        }

        if (level == maxLevel) {
            sum += node.val;
        }

        if (node.right != null) {
            dfs(node.right, level+1);            
        }

        if (node.left != null) {
            dfs(node.left, level+1);
        }
    }

}
