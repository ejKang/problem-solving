package com.ps.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ps.base.TreeNode;

public class LargestValues {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        LargestValues me = new LargestValues();
        me.largestValues(root);
    }

    public List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();

        if (root == null) {
            return rst;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.val > max) {
                    max = temp.val;
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
            }
            rst.add(max);
        }

        return rst;
    }
}
