package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author zhen
 *
 */
public class TwoSum {
	public class Solution {
		public int[] twoSum(int[] numbers, int target) {
			Map<Integer, List<Integer>> positions = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < numbers.length; i++) {
				List<Integer> list = positions.get(numbers[i]);
				if (list == null) {
					list = new ArrayList<Integer>();
				}

				list.add(i + 1);
				positions.put(numbers[i], list);
			}

			for (int number : numbers) {
				int rest = target - number;
				if (number == rest) {
					List<Integer> pos = positions.get(number);
					if (pos.size() >= 2) {
						int index1 = pos.get(0);
						int index2 = pos.get(1);
						return new int[] { index1, index2 };
					}
				} else {
					List<Integer> restPos = positions.get(rest);
					if (restPos != null) {
						int index1 = positions.get(number).get(0);
						int index2 = positions.get(rest).get(0);

						if (index1 > index2)
							return new int[] { index2, index1 };
						else
							return new int[] { index1, index2 };
					}
				}
			}

			return null;
		}
	}

	public static void main(String[] args) {
		TwoSum twosum = new TwoSum();
		Solution solution = twosum.new Solution();
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 2, 7, 3,
				9 }, 10)));
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 0, 4, 3,
				0 }, 0)));
	}
}
