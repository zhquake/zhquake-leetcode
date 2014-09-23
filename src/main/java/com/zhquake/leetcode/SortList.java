package com.zhquake.leetcode;

import com.zhquake.leetcode.common.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Zhang, Zhen(zhquake@163.com) Sep 22, 2014
 */
public class SortList {

    public class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode fast = head;
            ListNode slow = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = slow;
            slow = slow.next;
            fast.next = null;

            return merge(sortList(head), sortList(slow));
        }

        private ListNode merge(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(Integer.MIN_VALUE);
            ListNode index = head;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    index.next = l1;
                    l1 = l1.next;
                    index = index.next;
                } else {
                    index.next = l2;
                    l2 = l2.next;
                    index = index.next;
                }

            }

            while (l1 != null) {
                index.next = l1;
                l1 = l1.next;
                index = index.next;
            }

            while (l2 != null) {
                index.next = l2;
                l2 = l2.next;
                index = index.next;
            }

            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3123);
        head.next = new ListNode(1231);
        head.next.next = new ListNode(1931);
        head.next.next.next = new ListNode(4231);

        SortList sortList = new SortList();
        Solution solution = sortList.new Solution();

        System.out.println(solution.sortList(head));
    }
}
