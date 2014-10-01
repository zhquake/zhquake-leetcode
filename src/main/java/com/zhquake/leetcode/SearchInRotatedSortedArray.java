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
			int low = 0;
			int high = A.length - 1;

			while (low <= high) {
				int index = (low + high) / 2;
				if (target == A[index])
					return index;
				if (A[low] <= A[high]) {
					if (target > A[index]) {
						low = index + 1;
					} else {
						high = index;
					}
				} else {
					if (A[index] >= A[low]) {
						if (target > A[index]) {
							low = index + 1;
						} else if (target < A[low]) {
							low = index + 1;
						} else {
							high = index;
						}
					} else {
						if (target < A[index]) {
							high = index;
						} else if (target <= A[high]) {
							low = index + 1;
						} else {
							high = index;
						}
					}
				}
			}

			return -1;
		}
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
		Solution solution = search.new Solution();
		System.out.println(solution.search(new int[] { 5, 6, 1, 3 }, 1));
		System.out.println(solution.search(new int[] { 3, 1 }, 1));
		System.out.println(solution.search(new int[] { 3, 5, 1 }, 3));
		System.out.println(solution.search(new int[] { 5, 1, 3 }, 3));

	}
}
