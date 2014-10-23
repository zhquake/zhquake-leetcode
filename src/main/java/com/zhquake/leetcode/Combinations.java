package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 17, 2014
 */
public class Combinations {
    public class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            if (k > n || k == 0) {
                return result;
            }

            if (k == 1) {
                for (int i = 1; i <= n; i++) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    result.add(list);
                }
                return result;
            }

            int cur = n;
            while (cur > k) {
                for (List<Integer> item : combine(cur - 1, k - 1)) {
                    item.add(cur);
                    result.add(item);
                }
                cur--;
            }

            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= k; i++) {
                list.add(i);
            }
            result.add(list);
            return result;
        }
    }

    public static void main(String[] args) {
        Combinations com = new Combinations();
        Solution solution = com.new Solution();
        System.out.println(solution.combine(3, 2));
    }
}
