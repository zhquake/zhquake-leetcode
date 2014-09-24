package com.zhquake.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author Zhang, Zhen(zhquake@163.com) Sep 24, 2014
 */
public class MaximumProductSubarray {
	public class Solution {
		public int maxProduct(int[] A) {
			int pre = -1;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < A.length; i++) {
				if (A[i] == 0) {
					int blockMax = Integer.MIN_VALUE;
					if (pre + 1 <= i - 1) {
						blockMax = getMaxWithoutZero(A, pre + 1, i - 1);
					}
					if (blockMax < 0) {
						blockMax = 0;
					}
					if (blockMax > max) {
						max = blockMax;
					}
					pre = i;
				}
			}
			// the last block
			if (pre != A.length - 1) {
				int blockMax = getMaxWithoutZero(A, pre + 1, A.length - 1);
				if (blockMax > max) {
					max = blockMax;
				}

			}

			return max;
		}

		private int getMaxWithoutZero(int[] data, int begin, int end) {
			int cur = data[begin];
			int max = cur;
			for (int i = begin + 1; i <= end; i++) {
				cur = cur * data[i];
				if (cur > max) {
					max = cur;
				}
			}

			cur = data[end];
			if (cur > max)
				max = cur;
			for (int i = end - 1; i >= begin; i--) {
				cur = cur * data[i];
				if (cur > max) {
					max = cur;
				}
			}

			return max;
		}

	}

	public static void main(String[] args) {
		MaximumProductSubarray sub = new MaximumProductSubarray();
		Solution solution = sub.new Solution();

		System.out.println(solution.maxProduct(new int[] { 0, 3, 0, -1 }));
		System.out.println(solution.maxProduct(new int[] { -2, 0, -3 }));
		System.out.println(solution.maxProduct(new int[] { 3, -2 }));
		System.out.println(solution
				.maxProduct(new int[] { 1, 3, 5, -2, 11, 4 }));
		System.out.println(solution.maxProduct(new int[] { 1, 3, 5, -2, 0, 11,
				0, 4 }));

	}
}
