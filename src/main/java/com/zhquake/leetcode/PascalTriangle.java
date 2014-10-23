package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 16, 2014
 */
public class PascalTriangle {
    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (numRows == 0)
                return result;

            ArrayList<Integer> level1 = new ArrayList<Integer>();
            level1.add(1);
            result.add(level1);
            for (int i = 2; i <= numRows; i++) {
                ArrayList<Integer> level = new ArrayList<Integer>();
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        level.add(result.get(i - 1 - 1).get(0));
                    } else if (j == i - 1) {
                        level.add(result.get(i - 1 - 1).get(i - 1 - 1));
                    } else {
                        level.add(result.get(i - 1 - 1).get(j - 1)
                                + result.get(i - 1 - 1).get(j));
                    }
                }
                result.add(level);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        Solution solution = triangle.new Solution();
        System.out.println(solution.generate(5));
    }
}
