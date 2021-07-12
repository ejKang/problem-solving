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
}
