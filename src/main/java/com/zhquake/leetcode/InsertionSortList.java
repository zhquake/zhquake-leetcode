package com.zhquake.leetcode;

import com.zhquake.leetcode.common.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Zhang, Zhen(zhquake@163.com) Sep 22, 2014
 */
public class InsertionSortList {
    public class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode result = null;

            while (head != null) {
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
                result = insert(result, tmp);
            }

            return result;
        }

        private ListNode insert(ListNode head, ListNode node) {
            if (head == null) {
                head = node;
            } else {
                if (head.val < node.val) {
                    // recursive solution
                    // head.next = insert(head.next, node);

                    ListNode pre = head;
                    while (pre.next != null && pre.next.val < node.val) {
                        pre = pre.next;
                    }
                    node.next = pre.next;
                    pre.next = node;
                } else {
                    node.next = head;
                    head = node;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        Solution solution = insertionSortList.new Solution();

        System.out.println(solution.insertionSortList(ListNode.LIST_SAMPLE));
    }
}
