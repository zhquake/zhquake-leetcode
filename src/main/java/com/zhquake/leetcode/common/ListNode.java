package com.zhquake.leetcode.common;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.next != null) {
			builder.append(val).append(",");
			builder.append(this.next.toString());
			return builder.toString();
		} else {
			return builder.append(val).toString();
		}
	}

	public static ListNode buildListFromArray(int[] array) {
		if (array.length == 0) {
			return null;
		}

		ListNode head = new ListNode(array[0]);
		ListNode pre = head;
		for (int i = 1; i < array.length; i++) {
			ListNode node = new ListNode(array[i]);
			pre.next = node;
			pre = node;
		}

		return head;
	}

	public static ListNode LIST_SAMPLE = buildListFromArray(new int[] { 4, 7,
			1, 3, 9, 2, 6, 8, 5 });
}
