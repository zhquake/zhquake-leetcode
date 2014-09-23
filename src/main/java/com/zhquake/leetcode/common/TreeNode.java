package com.zhquake.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}

	public static TreeNode buildCompleteBinaryTreeFromArray(int[] array) {
		List<TreeNode> nodeArray = new ArrayList<TreeNode>();
		for (int i = 0; i < array.length; i++) {
			nodeArray.add(new TreeNode(array[i]));
		}

		for (int i = 1; i <= array.length / 2; i++) {
			TreeNode curNode = nodeArray.get(i - 1);
			curNode.left = nodeArray.get(2 * i - 1);
			if (2 * i < array.length)
				curNode.right = nodeArray.get(2 * i);
		}

		return nodeArray.get(0);
	}

	public static final TreeNode SAMPLE_TREE = buildCompleteBinaryTreeFromArray(new int[] {
			1, 2, 3, 4, 5, 6, 7, 8 });
}
