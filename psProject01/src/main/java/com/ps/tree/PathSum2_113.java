package com.ps.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
}
