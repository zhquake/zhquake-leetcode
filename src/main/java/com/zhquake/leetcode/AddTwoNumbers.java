package com.zhquake.leetcode;

import com.zhquake.leetcode.common.ListNode;

public class AddTwoNumbers {
	public class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode cur1 = l1;
	        ListNode cur2 = l2;
	        ListNode dummy = new ListNode(0);
	        int rest = 0;
	        ListNode cur = dummy;
	        while(cur1!=null&&cur2!=null){
	            int sum = cur1.val+cur2.val+rest;
	            if(sum < 10){
	                cur.next = new ListNode(sum);
	                cur = cur.next;
	                rest = 0;
	            }else{
	                cur.next = new ListNode(sum - 10);
	                cur = cur.next;
	                rest = 1;
	            }
	            cur1 = cur1.next;
	            cur2 = cur2.next;
	        }
	        
	        while(cur1!=null){
	            if(cur1.val+rest<10){
	                cur.next = new ListNode(cur1.val+rest);
	                cur = cur.next;
	                cur1 = cur1.next;
	                rest = 0;
	            }else{
	                cur.next = new ListNode(cur1.val+rest-10);
	                cur = cur.next;
	                rest = 1;
	                cur1 = cur1.next;
	            }
	        }
	        
	        while(cur2!=null){
	            if(cur2.val+rest<10){
	                cur.next = new ListNode(cur2.val+rest);
	                cur = cur.next;
	                cur2 = cur2.next;
	                rest = 0;
	            }else{
	                cur.next = new ListNode(cur2.val+rest-10);
	                cur = cur.next;
	                rest = 1;
	                cur2 = cur2.next;
	            }
	        }
	        
	        if(rest!=0){
	            cur.next = new ListNode(rest);
	        }
	        
	        return dummy.next;
	    }
	}
}
