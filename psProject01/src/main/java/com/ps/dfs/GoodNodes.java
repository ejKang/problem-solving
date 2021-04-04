package com.ps.dfs;

import com.ps.base.TreeNode;

public class GoodNodes {

    int rst = 0;

    public int goodNodes(TreeNode root) {

        if (root != null) {
            dfs(root, root.val);
        }
        return rst;
    }

    private void dfs(TreeNode node, int val) {

        val = Math.max(val, node.val);
        if (node.val >= val) {
            rst++;
        }

        if (node.right != null) {
            dfs(node.right, val);
        }

        if (node.left != null) {
            dfs(node.left, val);
        }
    }

}
