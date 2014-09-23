package com.zhquake.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

public class BinaryTreePreOrderTraversal {
	public static List<Integer> traverseWithRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		result.add(root.val);
		result.addAll(traverseWithRecursive(root.left));
		result.addAll(traverseWithRecursive(root.right));
		return result;
	}

	public static List<Integer> traverseWithInterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			result.add(cur.val);
			if(cur.right!=null){
				stack.push(cur.right);
			}
			if(cur.left!=null){
				stack.push(cur.left);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(traverseWithRecursive(TreeNode.SAMPLE_TREE));
		System.out.println(traverseWithInterative(TreeNode.SAMPLE_TREE));
	}
}
