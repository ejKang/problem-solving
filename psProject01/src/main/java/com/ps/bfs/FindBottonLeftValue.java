package com.ps.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.ps.base.TreeNode;

public class FindBottonLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return 0;
        }
        queue.add(root);

        int rst = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    rst = node.val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return rst;
    }
}
