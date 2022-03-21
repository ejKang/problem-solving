package com.ps.tree;

import java.util.Objects;
import java.util.Stack;

import com.ps.base.TreeNode;

public class IsSymmetric_101 {

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

    public boolean isSymmetric2_iterative(TreeNode root) {

        Stack<TreeNode> tree = new Stack<>();
        Stack<TreeNode> mirror = new Stack<>();

        tree.push(root.right);
        mirror.push(root.left);

        while (tree.size() > 0 && mirror.size() > 0) {
            TreeNode treetemp = tree.pop();
            TreeNode mirrortemp = mirror.pop();

            if (treetemp == null && mirrortemp == null) {
                continue;
            }

            if (treetemp == null || mirrortemp == null) {
                return false;
            }

            if (treetemp.val != mirrortemp.val) {
                return false;
            }

            tree.push(treetemp.left);
            mirror.push(mirrortemp.right);

            tree.push(treetemp.right);
            mirror.push(mirrortemp.left);

        }

        return true;
    }

    public boolean isSymmetric_recursive(TreeNode root) {

        TreeNode right = root.right;
        TreeNode left = root.left;

        return recursive(right, left);
    }

    private boolean recursive(TreeNode right, TreeNode left) {

        if (right == null && left == null) {
            return true;
        }

        if (right == null || left == null) {
            return false;
        }

        boolean valRst = right.val == left.val;
        boolean rRst = recursive(right.right, left.left);
        boolean lRst = recursive(right.left, left.right);

        return valRst && rRst && lRst;
    }

    public boolean isSymmetric_2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> mirror = new Stack<>();

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return true;
        } else if (Objects.isNull(root.left) || Objects.isNull(root.right)) {
            return false;
        }
        stack.add(root.left);
        mirror.add(root.right);

        while (!stack.isEmpty() && !mirror.isEmpty()) {
            TreeNode n = stack.pop();
            TreeNode m = mirror.pop();

            if (n.val != m.val) {
                return false;
            }

            if (Objects.isNull(n.left) && Objects.isNull(m.right)) {
                continue;
            } else if (Objects.isNull(n.left) || Objects.isNull(m.right)) {
                return false;
            } else {
                stack.add(n.left);
                mirror.add(m.right);
            }

            if (Objects.isNull(n.right) && Objects.isNull(m.left)) {
                // continue;
            } else if (Objects.isNull(n.right) || Objects.isNull(m.left)) {
                return false;
            } else {
                stack.add(n.right);
                mirror.add(m.left);
            }

        }
        return true;
    }

    public boolean isSymmetric_2_recursive(TreeNode root) {

        return recursive_2(root.left, root.right);
    }

    private boolean recursive_2(TreeNode left, TreeNode right) {

        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        }

        if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return recursive_2(left.left, right.right) && recursive_2(left.right, right.left);
    }
}
