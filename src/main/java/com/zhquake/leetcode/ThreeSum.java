package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü
 * b ¡Ü c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author zhen
 *
 */
public class ThreeSum {
	public class Solution {
		public List<List<Integer>> threeSum(int[] num) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			quickSort(num, 0, num.length - 1);
			int index1 = 0;
			while (index1 < num.length && num[index1] <= 0) {
				List<List<Integer>> items = findTwo(num, index1 + 1,
						num.length - 1, 0 - num[index1]);
				if (!items.isEmpty()) {
					for (List<Integer> item : items) {
						List<Integer> triple = new ArrayList<Integer>();
						triple.add(num[index1]);
						for (Integer value : item) {
							triple.add(value);
						}
						result.add(triple);
					}
				}

				index1++;
				while (index1 < num.length && num[index1] == num[index1 - 1]) {
					index1++;
				}
			}

			return result;
		}

		private List<List<Integer>> findTwo(int[] num, int begin, int end,
				int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			int index1 = begin;
			int index2 = end;
			while (index1 < index2) {
				int second = num[index1];
				int third = num[index2];
				if (second + third == target) {
					if (index1 == begin || num[index1] != num[index1 - 1]) {
						List<Integer> tuple = new ArrayList<Integer>();
						tuple.add(num[index1]);
						tuple.add(num[index2]);
						result.add(tuple);
					}
					index1++;
					index2--;
				} else if (second + third < target) {
					index1++;
				} else {
					index2--;
				}
			}
			return result;
		}

		public void quickSort(int[] num, int begin, int end) {
			if (end <= begin)
				return;

			Random random = new Random();
			int init = begin + random.nextInt(end - begin + 1);

			swap(num, init, end);
			int index = partition(num, begin, end);
			quickSort(num, begin, index - 1);
			quickSort(num, index + 1, end);

		}

		private void swap(int[] num, int from, int to) {
			int tmp = num[from];
			num[from] = num[to];
			num[to] = tmp;
		}

		private int partition(int[] num, int begin, int end) {
			int partition = num[end];
			int i = begin;
			int j = begin;
			while (i < end) {
				if (num[i] <= partition) {
					swap(num, i, j);
					j++;
				}
				i++;
			}

			swap(num, j, end);

			return j;
		}
	}

	public static void main(String[] args) {
		int[] data = new int[] { 2, 1, -3, -5, 2, 7, -8, 1, 3 };
		ThreeSum sum = new ThreeSum();
		Solution solution = sum.new Solution();

		System.out.println(solution.threeSum(data));
		System.out.println(solution.threeSum(new int[] { 0, 0, 0 }));

	}
}
