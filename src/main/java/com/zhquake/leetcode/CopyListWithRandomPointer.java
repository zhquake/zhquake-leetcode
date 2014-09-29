package com.zhquake.leetcode;

import com.zhquake.leetcode.common.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author zhen
 *
 */
public class CopyListWithRandomPointer {
	public class Solution {
		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null)
				return null;

			RandomListNode cur = head;
			while (cur != null) {
				RandomListNode newCreated = new RandomListNode(cur.label);
				newCreated.next = cur.next;
				cur.next = newCreated;
				cur = cur.next.next;
			}

			cur = head;
			RandomListNode dummy = new RandomListNode(Integer.MAX_VALUE);
			RandomListNode newCur = dummy;
			while (cur != null) {
				if (cur.random == null) {
					cur.next.random = null;
				} else {
					cur.next.random = cur.random.next;
				}
				cur = cur.next.next;
			}
			
			cur = head;
			while(cur!=null){
				newCur.next = cur.next;
				newCur = newCur.next;
				cur.next = cur.next.next;
				cur = cur.next;
			}
			
			newCur.next = null;
			
			return dummy.next;
		}
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		
		node1.next = node2;
		node1.random = node3;
		node2.next = node3;
		node2.random = null;
		node3.random = node1;
		
		System.out.println(node1);
		
		CopyListWithRandomPointer copy = new CopyListWithRandomPointer();
		Solution solution = copy.new Solution();
		System.out.println(solution.copyRandomList(node1));
		
	}
}
