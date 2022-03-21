package com.ps.tree;

import java.util.Objects;

import com.ps.base.TreeNode;

public class DiameterOfBT_543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        tree(root);
        return max;
    }

    private int tree(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int right = tree(node.right);
        int left = tree(node.left);

        max = Math.max(right + left, max);

        return Math.max(right, left) + 1;
    }

    public int diameterOfBinaryTree_2(TreeNode root) {

        int rootMaxDept = diaTree(root);
        System.out.println(rootMaxDept);
        return max;
    }

    private int diaTree(TreeNode node) {

        if (Objects.isNull(node)) {
            return 0;
        }

        int right = diaTree(node.right);
        int left = diaTree(node.left);

        max = Math.max(max, right + left);

        return Math.max(right, left) + 1;
    }

    public int max_2 = 0;

    public int diameterOfBinaryTree_3(TreeNode root) {

        recursive_2(root);
        return max_2;
    }

    public static void main(String[] args) {
        DiameterOfBT_543 d = new DiameterOfBT_543();
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node.left = node2;
        d.recursive_2(node);
        System.out.println(d.max_2);
    }

    private int recursive_2(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int r = 0;
        if (node.right != null) {
            r = recursive_2(node.right) + 1;
        }
        int l = 0;
        if (node.left != null) {
            l = recursive_2(node.left) + 1;
        }

        int tmp = Math.max(r, l);
        max_2 = Math.max(max_2, l + r);
        return tmp;
    }
}
