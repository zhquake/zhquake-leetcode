package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.zhquake.leetcode.common.ListNode;

public class MergeKSortedLists {
	public class Solution {
		public ListNode mergeKLists(List<ListNode> lists) {
			return solution2(lists);
		}

		public ListNode solution1(List<ListNode> lists) {
			ArrayList<ListNode> rest = new ArrayList<ListNode>();
			for (ListNode head : lists) {
				if (head != null)
					rest.add(head);
			}

			ListNode dummy = new ListNode(0);
			ListNode cur = dummy;
			while (!rest.isEmpty()) {
				ListNode min = new ListNode(Integer.MAX_VALUE);

				for (ListNode item : rest) {
					if (item.val <= min.val) {
						min = item;
					}
				}

				cur.next = min;
				cur = cur.next;
				rest.remove(min);
				min = min.next;
				if (min != null) {
					rest.add(min);
					cur.next = null;
				}

			}

			return dummy.next;
		}

		public ListNode solution2(List<ListNode> lists) {
			ArrayList<ListNode> rest = new ArrayList<ListNode>();
			for (ListNode head : lists) {
				if (head != null)
					rest.add(head);
			}
			for (int i = (rest.size() - 1 - 1) / 2; i >= 0; i--) {
				minHeapify(rest, rest.size(), i);
			}

			ListNode dummy = new ListNode(0);
			ListNode cur = dummy;

			while (!rest.isEmpty()) {
				cur.next = rest.get(0);
				cur = cur.next;
				if (cur.next != null) {
					rest.set(0, cur.next);
					minHeapify(rest, rest.size(), 0);
					cur.next = null;
				} else {
					if (rest.size() == 1) {
						return dummy.next;
					} else {
						rest.set(0, rest.get(rest.size() - 1));
						rest.remove(rest.size() - 1);
						minHeapify(rest, rest.size(), 0);
					}
				}
			}
			return dummy.next;
		}

		void minHeapify(ArrayList<ListNode> lists, int heapsize, int index) {
			int min = index;

			if (index * 2 + 1 < heapsize
					&& lists.get(index * 2 + 1).val < lists.get(min).val) {
				min = (index * 2 + 1);
			}

			if (index * 2 + 2 < heapsize
					&& lists.get(index * 2 + 2).val < lists.get(min).val) {
				min = (index * 2 + 2);
			}

			if (min != index) {
				ListNode tmp = lists.get(index);
				lists.set(index, lists.get(min));
				lists.set(min, tmp);
				minHeapify(lists, heapsize, min);
			}

		}
	}

	public static void main(String[] args) {
		MergeKSortedLists merge = new MergeKSortedLists();
		Solution solution = merge.new Solution();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(ListNode.buildListFromArray(new int[] { 11,22,33,44 }));
		lists.add(ListNode.buildListFromArray(new int[] { 1,10,100 }));
		lists.add(ListNode.buildListFromArray(new int[] { 5,15,25 }));
		System.out.println(solution.mergeKLists(lists));
	}
}
