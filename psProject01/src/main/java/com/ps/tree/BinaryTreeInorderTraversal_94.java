package com.ps.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ps.base.TreeNode;

public class BinaryTreeInorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            recursive(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            recursive(node.right, list);
        }
    }

    public List<Integer> inorderTraversal_iterative(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                if (tmp.right != null) {
                    cur = tmp.right;
                }
            } else {
                break;
            }
        }

        return list;
    }
}
