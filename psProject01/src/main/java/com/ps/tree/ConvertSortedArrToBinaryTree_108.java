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
}
