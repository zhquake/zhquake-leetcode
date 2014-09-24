package com.zhquake.leetcode;

import com.zhquake.leetcode.common.ListNode;

/**
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to:
 * L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author zhen
 *
 */
public class ReorderList {
	public class Solution {
		public void reorderList(ListNode head) {
			if(head == null)
				return;
			ListNode slow = head;
			ListNode fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			ListNode block1 = head;
			ListNode block2 = slow.next;
			slow.next = null;

			// reverse block2
			ListNode pre = block2;
			if (pre != null) {
				ListNode cur = pre.next;
				pre.next = null;
				ListNode next = null;
				while (cur != null) {
					next = cur.next;
					cur.next = pre;
					pre = cur;
					cur = next;
				}
				block2 = pre;
			}

			ListNode tmp = null;
			while (block2 != null) {
				tmp = block2.next;
				block2.next = block1.next;
				block1.next = block2;
				block2 = tmp;
				block1 = block1.next.next;
			}
		}
	}

	public static void main(String[] args) {
		ReorderList reorder = new ReorderList();
		Solution solution = reorder.new Solution();

		ListNode head = ListNode.LIST_SAMPLE;
		System.out.println(head);
		solution.reorderList(head);
		System.out.println(head);
	}
}
