package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * @author zhen
 *
 */
public class BinaryTreePreorderTraversal {
	public class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;

			TreeNode cur = root;
			Stack<TreeNode> parentStack = new Stack<TreeNode>();

			while (!parentStack.isEmpty() || cur != null) {
				if (cur != null) {
					result.add(cur.val);
					parentStack.push(cur);
					cur = cur.left;
				} else {
					cur = parentStack.pop();
					cur = cur.right;
				}
			}
			return result;
		}
	}
}
