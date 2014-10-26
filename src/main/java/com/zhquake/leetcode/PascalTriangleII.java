package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 16, 2014
 */
public class PascalTriangleII {
    public class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<Integer>();
            if (rowIndex < 0)
                return result;

            result.add(1);

            for (int i = 2; i <= rowIndex + 1; i++) {
                int pre = 1;
                for (int j = 1; j < i - 1; j++) {
                    int n = pre + result.get(j);
                    pre = result.get(j);
                    result.set(j, n);
                }
                result.add(1);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        PascalTriangleII pascal = new PascalTriangleII();
        Solution solution = pascal.new Solution();
        System.out.println(solution.getRow(0));
    }
}
