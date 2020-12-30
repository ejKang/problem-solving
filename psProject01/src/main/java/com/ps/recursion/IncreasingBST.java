package com.ps.recursion;

import java.util.ArrayList;
import java.util.List;

import com.ps.base.TreeNode;

public class IncreasingBST {
    TreeNode rst ;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        TreeNode root = new TreeNode(10,left, right);

        System.out.println(increasingBST(root));

    }

    public static TreeNode increasingBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        recursiveMethod(root, list);

        TreeNode rst = new TreeNode(0);
        TreeNode cur = rst;

        for (Integer i : list) {
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return rst.right;   
    }

    private static void recursiveMethod(TreeNode node, List<Integer> list) {

        if (node != null) {
            
            recursiveMethod(node.left, list);

            list.add(node.val);

            recursiveMethod(node.right, list);

        }
    }
}
