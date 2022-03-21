package com.ps.tree;

import java.util.Objects;
import java.util.Stack;

import com.ps.base.TreeNode;

public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (Objects.isNull(node)) {
                continue;
            }
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;

            stack.push(node.right);
            stack.push(node.left);
        }

        return root;
    }

    public TreeNode invertTreeRecursive(TreeNode root) {

        recursive(root);
        return root;
    }

    private void recursive(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;

        recursive(node.right);
        recursive(node.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node3;
        root.left = node2;

        InvertTree_226 ii = new InvertTree_226();
        ii.invertTreeRecursive(root);

    }

    public TreeNode invertTree_2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n == null) {
                continue;
            }
            TreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;
            stack.add(n.left);
            stack.add(n.right);
        }
        return root;
    }

    public TreeNode invertTree_2_recursive(TreeNode root) {

        recursive_2(root);
        return root;
    }

    private void recursive_2(TreeNode n) {
        if (n == null) {
            return;
        }

        TreeNode tmp = n.left;
        n.left = n.right;
        n.right = tmp;

        recursive_2(n.left);
        recursive_2(n.right);
    }
}
