package com.zhquake.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author zhen
 *
 */
public class SearchInRotatedSortedArray {
	public class Solution {
		public int search(int[] A, int target) {
			if (A.length == 0)
				return -1;

			int head = 0;
			int tail = A.length - 1;

			while (head != tail) {
				int index = (head + tail) / 2;
				if (A[head] < A[tail]) {
					if (target > A[index]) {
						head = index;
					} else if (target < A[index]) {
						tail = index;
					} else {
						return index;
					}
				} else {
					if (target > A[index]) {
						if (A[index] > A[head]) {
							head = index;
						} else {
							tail = index;
						}
					} else if (target < A[index]) {
						if (A[index] > A[head]) {
							tail = index;
						} else {
							head = index;
						}
					} else {
						return index;
					}
				}
			}

			if (A[head] == target)
				return head;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
		Solution solution = search.new Solution();
		System.out.println(solution.search(new int[] { 5, 6, 1, 3 }, 1));
	}
}
