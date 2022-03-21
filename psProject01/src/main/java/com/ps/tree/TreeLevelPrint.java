package com.ps.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.ps.base.TreeNode;

public class TreeLevelPrint {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        TreeLevelPrint.levelPrint(n1);
    }

    public static void levelPrint(TreeNode n) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(n);

        while (queue.size() != 0) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + ", ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }

        }
    }

    public static void levelPrint_line(TreeNode n) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(n);

        while (queue.size() != 0) {
            int cnt = queue.size();

            for (int i = 0; i < cnt; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + ", ");
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            System.out.println("");

        }
    }
}
