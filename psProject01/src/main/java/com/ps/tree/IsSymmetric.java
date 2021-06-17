package com.ps.tree;

import java.util.Stack;

import com.ps.base.TreeNode;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> mirroStack = new Stack<>();

        stack.push(root.left);
        mirroStack.push(root.right);
        boolean rst = true;
        while (stack.size() > 0 && mirroStack.size() > 0) {
            TreeNode s = stack.pop();
            TreeNode m = mirroStack.pop();

            if (s == null && m == null) {
                continue;
            }

            if (s == null || m == null) {
                return false;
            }

            if (s.val != m.val) {
                return false;
            }

            stack.push(s.left);
            mirroStack.push(m.right);
            stack.push(s.right);
            mirroStack.push(m.left);
        }
        return rst;
    }
}
