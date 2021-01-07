package com.ps.recursion;

import com.ps.base.TreeNode;

public class FindTilt {

    public static int rst = 0;

    public static void main(String[] args) {

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(10,left, right);

        System.out.println(findTilt(root));
    }

    public static int findTilt(TreeNode root) {
        rst = 0;

        recursionMethod(root);

        return rst;   
    }

    public static int recursionMethod(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = recursionMethod(node.left);
        int right = recursionMethod(node.right);

        int temp = Math.abs(left - right);
        rst += temp; // this value for totalSum

        return node.val + left + right ; // this value for recursion calculate
    }
}