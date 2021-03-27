package com.ps.dfs;

import com.ps.base.TreeNode;

public class getTargetCopy {

    public static void main(String[] args) {
        

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        TreeNode node = new TreeNode(1, node1, node2);

        TreeNode node3 = new TreeNode(4);
        node1.left = node3;

        getTargetCopy a = new getTargetCopy();
        

        a.getTargetCopy1(node, node, node3);
        
    }
    

    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode rst = null;
        dfs(cloned, target,rst);
        return rst;
    }

    private void dfs(TreeNode original, TreeNode target, TreeNode rst) {
        if (original.val == target.val) {
            rst = original;
            return;
        }
        if (original.left != null) {
            dfs(original.left, target, rst);
        }

        if (original.right!= null) {
            dfs(original.right, target,rst);
        }

    }
}
