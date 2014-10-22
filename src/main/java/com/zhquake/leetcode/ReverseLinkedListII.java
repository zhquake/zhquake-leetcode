package com.zhquake.leetcode;

import com.zhquake.leetcode.common.ListNode;

public class ReverseLinkedListII {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode before;
			ListNode after;
			ListNode start;

			before = null;
			ListNode helper = head;
			for (int i = 1; i < m; i++) {
				before = helper;
				helper = helper.next;
			}

			if (before == null) {
				start = head;
			} else {
				start = before.next;
			}

			ListNode end;
			ListNode pre = start;
			ListNode cur = start.next;
			for (int i = m; i < n; i++) {
				ListNode tmp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = tmp;
			}
			end = pre;
			after = cur;

			if (before != null) {
				before.next = end;
				start.next = after;
				return head;
			} else {
				start.next = after;
				return end;
			}
		}
	}
}
