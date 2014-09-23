package com.zhquake.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

public class BinaryTreeInOrderTraversal {
	public static List<Integer> traverseWithRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		result.addAll(traverseWithRecursive(root.left));
		result.add(root.val);
		result.addAll(traverseWithRecursive(root.right));

		return result;
	}

	public static List<Integer> traverseWithIterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode previsited = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();

			if (cur.left == null && previsited != cur.left && previsited != cur.right) {
				result.add(cur.val);
				previsited = cur;
				stack.pop();
				if (cur.right != null)
					stack.push(cur.right);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		System.out.println(traverseWithRecursive(TreeNode.SAMPLE_TREE));
		System.out.println(traverseWithIterative(TreeNode.SAMPLE_TREE));
	}
}
