package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Sep 22, 2014
 */
public class BinaryTreePostorderTraversal {
	public class Solution {

		public List<Integer> postorderTraversal(TreeNode root) {
			// return postorderRecursive(root);
			return postorderInterative2(root);
		}

		private List<Integer> postorderRecursive(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();

			if (root != null) {
				result.addAll(postorderTraversal(root.left));
				result.addAll(postorderTraversal(root.right));
				result.add(root.val);
			}

			return result;
		}

		private List<Integer> postorderInterative1(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			Stack<TreeNode> stack = new Stack<TreeNode>();

			TreeNode pre = null;
			TreeNode cur = null;

			if (root == null)
				return result;

			stack.push(root);
			while (!stack.isEmpty()) {
				cur = stack.peek();
				if (cur.left == null && cur.right == null) {
					// The node has no children can can be visited directly
					result.add(cur.val);
					stack.pop();
				} else if (pre == cur.left || pre == cur.right) {
					// The node's children have already been visited
					result.add(cur.val);
					stack.pop();
				} else {
					// put right node in stack first, so left node will be
					// visited before right
					if (cur.right != null) {
						stack.push(cur.right);
					}

					if (cur.left != null) {
						stack.push(cur.left);
					}
				}

				pre = cur;
			}

			return result;
		}

		private List<Integer> postorderInterative2(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			Stack<TreeNode> parentStack = new Stack<TreeNode>();

			if (root == null)
				return result;

			TreeNode cur = root;
			TreeNode preVisited = null;

			// while (!parentStack.isEmpty() || cur != null)
			do {
				if (cur != null) {
					parentStack.push(cur);
					cur = cur.left;
				} else {
					TreeNode peeknode = parentStack.peek();
					if (peeknode.right != null && preVisited != peeknode.right) {
						cur = peeknode.right;
					} else {
						preVisited = peeknode;
						result.add(peeknode.val);
						parentStack.pop();
					}
				}
			} while (!parentStack.isEmpty());

			return result;

		}

	}

	public static void main(String[] args) {
		BinaryTreePostorderTraversal postTra = new BinaryTreePostorderTraversal();
		Solution solution = postTra.new Solution();

		System.out.println(solution.postorderTraversal(TreeNode.SAMPLE_TREE));
	}

}
