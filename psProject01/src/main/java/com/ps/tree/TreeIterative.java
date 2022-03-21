package com.ps.tree;

import java.util.Objects;
import java.util.Stack;

import com.ps.base.TreeNode;

public class TreeIterative {

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

		System.out.println("PostOrder");
		iterativePostOrder(n1);

		System.out.println("");
		System.out.println("PreOrder");
		iterativePreOrder(n1);

		System.out.println("");
		System.out.println("InOrder");
		iterativeInOrder(n1);

		TreeIterative it = new TreeIterative();
		System.out.println("");
		System.out.println("InOrder");
		it.iterativeInOrder_2(n1);

		System.out.println("");
		System.out.println("PostOrder");
		it.iterativePostOrder_2(n1);

	}

	private static void iterativeInOrder(TreeNode n) {
		if (Objects.isNull(n)) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = n;
		while (true) {
			if (Objects.nonNull(current)) {
				stack.push(current);
				current = current.left;
			} else if (stack.size() > 0) {
				current = stack.pop();
				System.out.print(current.val + " - ");
				current = current.right;
			} else {
				break;
			}
		}
	}

	private static void iterativePreOrder(TreeNode n) {

		if (Objects.isNull(n)) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(n);

		while (stack.size() > 0) {
			TreeNode tmp = stack.pop();
			System.out.print(tmp.val + " - ");

			if (Objects.nonNull(tmp.right)) {
				stack.push(tmp.right);
			}

			if (Objects.nonNull(tmp.left)) {
				stack.push(tmp.left);
			}
		}
	}

	private static void iterativePostOrder(TreeNode n) {

		if (Objects.isNull(n)) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		TreeNode current = n;
		TreeNode latest = null;

		while (true) {

			if (Objects.nonNull(current)) {
				stack.push(current);
				current = current.left;
			} else if (stack.size() > 0) {
				TreeNode tmp = stack.peek();

				if (Objects.nonNull(tmp.right) && tmp.right != latest) {
					current = tmp.right;
				} else {
					System.out.print(tmp.val + " - ");
					latest = stack.pop();
				}
			} else {

				break;
			}
		}
	}

	public void iterativePreOrder_2(TreeNode n) {
		if (Objects.isNull(n)) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(n);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + ", ");

			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}

		}

	}

	public void iterativeInOrder_2(TreeNode n) {

		if (n == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = n;

		while (true) {
			if (cur != null) {
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			} else if (stack.size() > 0) {
				cur = stack.pop();
				System.out.print(cur.val + ", ");
				cur = cur.right;
			} else {
				break;
			}
		}
	}

	public void iterativePostOrder_2(TreeNode n) {

		if (Objects.isNull(n)) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = n;
		TreeNode latest = null;

		while (true) {

			if (current != null) {

				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			} else if (stack.size() > 0) {
				TreeNode tmp = stack.peek();
				if (tmp.right != null && latest != tmp.right) {
					current = tmp.right;
				} else {
					System.out.print(tmp.val + ", ");
					latest = stack.pop();
				}
			} else {
				break;
			}
		}
	}
}
