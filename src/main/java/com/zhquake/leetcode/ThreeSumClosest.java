package com.zhquake.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author zhen
 *
 */
public class ThreeSumClosest {
	public class Solution {
		public int threeSumClosest(int[] num, int target) {
			int closest = 0;
			if (num.length <= 2)
				return closest;

			Arrays.sort(num);
			int gap = Integer.MAX_VALUE;
			for (int i = 0; i <= num.length - 3; i++) {
				int first = i + 1;
				int last = num.length - 1;

				while (first < last) {
					int sum = num[i] + num[first] + num[last];

					if (sum == target)
						return target;

					if (Math.abs(sum - target) < gap) {
						closest = sum;
						gap = Math.abs(sum - target);
					}

					if (sum > target) {
						last--;
					} else {
						first++;
					}

				}
			}
			return closest;
		}
	}

	public static void main(String[] args) {
		ThreeSumClosest sum = new ThreeSumClosest();
		Solution solution = sum.new Solution();

		System.out.println(solution.threeSumClosest(new int[] { -1, 2, 1, 4 },
				1));
		System.out.println(solution.threeSumClosest(new int[] { 0, 1, 2 }, 3));
		System.out.println(solution.threeSumClosest(new int[] { 1, 1, 1, 0 },
				100));
	}
}
