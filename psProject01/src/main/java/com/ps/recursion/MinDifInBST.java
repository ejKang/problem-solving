package com.ps.recursion;

import com.ps.base.TreeNode;

public class MinDifInBST {
    
    static int rst = Integer.MAX_VALUE;
    static int previousValue = -1;
    public static void main(String[] args) {

        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(7,left, right);
        System.out.println(minDiffInBST(root));
    }
    
    public static int minDiffInBST(TreeNode root) {

        recursiveMethod(root);

        return rst;   
    }

    private static void recursiveMethod(TreeNode node) {

        if (node.left != null) {
            recursiveMethod(node.left);
        }
        if (previousValue != -1) {
            rst = Math.min(node.val - previousValue, rst);
        }
        previousValue = node.val;

        if (node.right != null ) {
            recursiveMethod(node.right);
        }
    }
}
