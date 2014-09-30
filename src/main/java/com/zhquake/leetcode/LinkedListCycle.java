package com.zhquake.leetcode;

import com.zhquake.leetcode.common.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Sep 26, 2014
 */
public class LinkedListCycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null)
                return false;

            ListNode slow = head;
            ListNode fast = head;

            while (true) {
                if (slow == null)
                    return false;
                else
                    slow = slow.next;

                if (fast == null || fast.next == null)
                    return false;
                else
                    fast = fast.next.next;

                if (slow == fast)
                    return true;
            }

        }
    }
}
