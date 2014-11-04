package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü
 * ¡­ ¡Ü ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author zhen
 *
 */
public class CombinationSumII {
	public class Solution {
		public List<List<Integer>> combinationSum2(int[] num, int target) {
			Arrays.sort(num);
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			ArrayList<Integer> intermediate = new ArrayList<Integer>();
			combinationSum2(num, target, 0, 0, result, intermediate);
			return result;
		}

		void combinationSum2(int[] num, int target, int curSum, int begin,
				List<List<Integer>> result, List<Integer> intermediate) {
			if (curSum == target) {
				result.add(new ArrayList<Integer>(intermediate));
				return;
			}
			if (curSum > target) {
				return;
			}
			for (int i = begin; i < num.length; i++) {
				intermediate.add(num[i]);
				combinationSum2(num, target, curSum + num[i], i + 1, result,
						intermediate);
				intermediate.remove(intermediate.size() - 1);

				while(i+1<num.length&&num[i+1]==num[i]){
					i++;
				}
			}
		}
		
		public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
				int target) {
			ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> solution = new ArrayList<Integer>();
			Arrays.sort(candidates);
			combinationSum(candidates, 0, 0, target, ret, solution);
			return ret;
		}

		private void combinationSum(int[] candidates, int start, int sum,
				int target, ArrayList<ArrayList<Integer>> ret,
				ArrayList<Integer> solution) {
			if (sum == target) {
				ret.add(new ArrayList<Integer>(solution));
				return;
			}
			if (sum > target)
				return;
			for (int i = start; i < candidates.length; i++) {
				solution.add(candidates[i]);
				combinationSum(candidates, i, sum + candidates[i], target, ret, solution);
				solution.remove(solution.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		CombinationSumII sumII = new CombinationSumII();
		Solution solution = sumII.new Solution();
		System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
		System.out.println(solution.combinationSum(new int[]{2,2,3,6,7}, 7));

	}
}
