package com.ps.tree;

import com.ps.base.TreeNode;

public class ConvertSortedArrToBinaryTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start + end) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.right = recursive(nums, mid + 1, end);
        newNode.left = recursive(nums, start, mid - 1);
        return newNode;
    }

    public TreeNode sortedArrayToBST_2(int[] nums) {

        TreeNode node = toBinarySearchTreeRecursive(nums, 0, nums.length - 1);
        return node;

    }

    private TreeNode toBinarySearchTreeRecursive(int[] nums, int start, int end) {

        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toBinarySearchTreeRecursive(nums, start, mid - 1);
        node.right = toBinarySearchTreeRecursive(nums, mid + 1, end);

        return node;
    }
}
