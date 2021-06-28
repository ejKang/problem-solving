package com.ps.tree;

import java.util.Objects;

import com.ps.base.TreeNode;

public class TreeRecursive {

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
		
		System.out.println("PreOrder");
		recursivePreOrder(n1);
		
		System.out.println("");
		System.out.println("InOrder");
		recursiveInOrder(n1);
		
		System.out.println("");
		System.out.println("PostOrder");
		recursivePostOrder(n1);
	}

	private static void recursivePostOrder(TreeNode n) {
		
		if (Objects.isNull(n)) {
			return ;
		}
		
		recursivePostOrder(n.left);
		recursivePostOrder(n.right);
		
		System.out.print(n.val + " - ");
	}

	private static void recursiveInOrder(TreeNode n) {

		if (Objects.isNull(n)) {
			return ;
		}
		
		recursiveInOrder(n.left);
		
		System.out.print(n.val + " - ");
		
		recursiveInOrder(n.right);
	}

	private static void recursivePreOrder(TreeNode n) {
		
		if (Objects.isNull(n)) {
			return;
		}
		
		System.out.print(n.val + " - ");
		
		recursivePreOrder(n.left);
		recursivePreOrder(n.right);
		
	}
}
