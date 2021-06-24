package com.ps.tree;

import com.ps.base.TreeNode;

public class LowestCommonAncestor_236 {

    TreeNode rst = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        tree(root, p, q);

        return rst;
    }

    private boolean tree(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return false;
        }

        boolean ll = tree(node.left, p, q);
        boolean rr = tree(node.right, p, q);
        boolean cur = (node.val == p.val || node.val == q.val);

        int cnt = 0;
        if (ll)
            cnt++;
        if (rr)
            cnt++;
        if (cur)
            cnt++;

        if (cnt >= 2) {
            rst = node;
        }

        return ll || rr || cur;
    }
}
