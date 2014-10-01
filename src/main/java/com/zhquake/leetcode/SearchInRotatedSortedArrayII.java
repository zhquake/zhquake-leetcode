package com.zhquake.leetcode;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * (i.e., 0 1 2 2 4 5 6 7 might become 2 4 5 6 7 0 1 2)
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author zhen
 *
 */
public class SearchInRotatedSortedArrayII {
	public class Solution {
		public boolean search(int[] A, int target) {
			int first = 0;
			int last = A.length - 1;

			while (first <= last) {
				int index = (first + last) / 2;
				if (A[index] == target)
					return true;

				if (A[first] == A[last]) {
					first++;
				} else if (A[first] < A[last]) {
					if (target < A[index]) {
						last = index;
					} else {
						first = index + 1;
					}
				} else {
					if (A[index] >= A[first]) {
						if (target >= A[first] && target < A[index]) {
							last = index;
						} else {
							first = index + 1;
						}
					} else {
						if (target > A[index] && target <= A[last]) {
							first = index + 1;
						} else {
							last = index;
						}
					}
				}

			}

			return false;
		}
	}
}
