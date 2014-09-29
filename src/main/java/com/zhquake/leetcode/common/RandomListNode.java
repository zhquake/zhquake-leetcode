package com.zhquake.leetcode.common;

/**
 * Definition for singly-linked list with a random pointer.
 */
public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}

	@Override
	public String toString() {
		String result = "";
		result += ("l" + label);
		result += ("r" + (random == null ? null : random.label));
		if (next == null)
			return result;
		else{
			return result + "," + next;
		}
	}
}
