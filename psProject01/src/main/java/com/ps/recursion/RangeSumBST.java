package com.ps.recursion;

import com.ps.base.TreeNode;

public class RangeSumBST {
    
    public static void main(String[] args) {
        
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(10,left, right);

        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        sum = recurs(root, low, high, sum);
        return sum;    
    }

    private static int recurs(TreeNode node, int l, int r, int sum) {

        if (l <= node.val && node.val <= r) {
            sum += node.val;
        }
        if (node.left != null) {
            sum += recurs(node.left, l, r, 0);
        }
        if (node.right != null) {
            sum += recurs(node.right, l, r, 0);
        }
        return sum;
    }
}
