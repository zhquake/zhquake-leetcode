package com.zhquake.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author zhen
 *
 */
public class LongestConsecutiveSequence {
	public class Solution {
		public int longestConsecutive(int[] num) {
			int longest = 0;
			Set<Integer> pastData = new HashSet<Integer>();

			for (int data : num) {
				pastData.add(data);
			}

			for (int data : num) {
				int curLong = 1;
				int cur = data;
				while (pastData.contains(++cur)) {
					pastData.remove(cur);
					curLong++;
				}

				cur = data;
				while (pastData.contains(--cur)) {
					pastData.remove(cur);
					curLong++;
				}

				longest = Math.max(curLong, longest);
			}
			return longest;
		}
	}
}
