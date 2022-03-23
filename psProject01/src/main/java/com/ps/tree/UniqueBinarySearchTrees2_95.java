package com.ps.tree;

import java.util.ArrayList;
import java.util.List;

import com.ps.base.TreeNode;

public class UniqueBinarySearchTrees2_95 {

    public List<TreeNode> generateTrees(int n) {

        return recursive(1, n);
    }

    private List<TreeNode> recursive(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = recursive(start, i - 1);
            List<TreeNode> right = recursive(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode node = new TreeNode(i, leftNode, rightNode);
                    list.add(node);
                }
            }
        }
        return list;
    }

    public List<TreeNode> generateTrees_2(int n) {

        return genRecursive(1, n);
    }

    private List<TreeNode> genRecursive(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        } else if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = genRecursive(start, i - 1);
            List<TreeNode> right = genRecursive(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i, l, r);
                    list.add(node);
                }
            }
        }

        return list;
    }
}
