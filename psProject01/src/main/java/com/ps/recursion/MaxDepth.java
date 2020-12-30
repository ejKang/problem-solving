package com.ps.recursion;

import com.ps.base.TreeNode;

public class MaxDepth {
    
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(10,left, right);
        
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        
        int rst = 0;
        rst = recursiveMethod(root, rst);
        return rst;    
    }

    private static int recursiveMethod(TreeNode node, int rst) {
        
        if (node != null) {
            rst ++;

            int left = recursiveMethod(node.left, rst);
            int right = recursiveMethod(node.right, rst);

            return Math.max(right, left);
        } else {
            return rst;
        }

        
    
    }
}
