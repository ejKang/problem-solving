package com.ps.tree;

import java.util.Stack;

import com.ps.base.TreeNode;

public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        boolean rst = recursive(root, targetSum, 0);
        return rst;
    }

    private boolean recursive(TreeNode node, int targetSum, int curSum) {

        if (node == null) {
            return false;
        }

        curSum += node.val;

        if (node.right == null && node.left == null && curSum == targetSum) {
            return true;
        }

        boolean b = recursive(node.right, targetSum, curSum) || recursive(node.left, targetSum, curSum);
        curSum -= node.val;
        return b;
    }

    public boolean hasPathSum_iterative(TreeNode root, int targetSum) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode prev = null;

        int sum = 0;
        while (true) {
            if (cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    sum += cur.val;
                    cur = cur.left;
                }
            } else if (!stack.isEmpty()) {
                TreeNode tmp = stack.peek();

                if (tmp.right != null && prev != tmp.right) {
                    cur = tmp.right;
                } else if (sum == targetSum && tmp.right == null && tmp.left == null) {
                    return true;
                } else {
                    sum -= tmp.val;
                    prev = stack.pop();
                    // cur = null;
                }
            } else {
                break;
            }

        }
        return true;
    }
}
