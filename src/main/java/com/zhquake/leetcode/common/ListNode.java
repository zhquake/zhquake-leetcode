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
}
