package com.ps.recursion;

import com.ps.base.TreeNode;

public class FindTilt {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(10,left, right);

        System.out.println(findTilt(root));
    }

    public static int findTilt(TreeNode root) {
        return 0;   
    }
}
