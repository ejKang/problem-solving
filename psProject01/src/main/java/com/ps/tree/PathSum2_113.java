package com.ps.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import com.ps.base.TreeNode;

public class PathSum2_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> rst = new ArrayList<>();

        bt(rst, new ArrayList<Integer>(), root, targetSum);

        return rst;
    }

    private void bt(List<List<Integer>> rst, ArrayList<Integer> list, TreeNode node, int targetSum) {

        if (Objects.isNull(node)) {
            return;
        }

        if (node.val == targetSum && Objects.isNull(node.right) && Objects.isNull(node.left)) {
            list.add(node.val);
            rst.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        if (!Objects.isNull(node.right)) {
            // list.add(node.right.val);
            bt(rst, list, node.right, targetSum - node.val);
            // list.remove(list.size() - 1);

        }

        if (!Objects.isNull(node.left)) {
            // list.add(node.left.val);
            bt(rst, list, node.left, targetSum - node.val);
            // list.remove(list.size() - 1);

        }
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum_2(TreeNode root, int targetSum) {

        List<List<Integer>> rst = new ArrayList<>();

        treeBacktracking(rst, new ArrayList<>(), root, targetSum);

        return rst;
    }

    private void treeBacktracking(List<List<Integer>> rst, List<Integer> list, TreeNode node, int targetSum) {

        if (Objects.isNull(node)) {
            return;
        }

        list.add(node.val);

        if (targetSum == node.val && Objects.isNull(node.right) && Objects.isNull(node.left)) {
            rst.add(new ArrayList<>(list));

        } else {
            treeBacktracking(rst, list, node.right, targetSum - node.val);
            treeBacktracking(rst, list, node.left, targetSum - node.val);
        }

        list.remove(list.size() - 1);

    }

    public List<List<Integer>> pathSum_iterative(TreeNode root, int targetSum) {

        List<List<Integer>> rst = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;
        TreeNode pre = null;
        int sum = 0;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                list.add(curr.val);

                sum += curr.val;
                curr = curr.left;
            }

            curr = stack.peek();
            if (curr.right != null && curr.right != pre) {
                curr = curr.right;
                continue;
            }

            if (curr.left == null && curr.right == null && sum == targetSum) {
                rst.add(new ArrayList<>(list));
            }

            pre = stack.pop();
            list.remove(list.size() - 1);
            sum -= pre.val;
            curr = null;
        }

        return rst;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node3;
        root.left = node2;

        PathSum2_113 ii = new PathSum2_113();
        ii.pathSum_iterative(root, 4);

    }
}
