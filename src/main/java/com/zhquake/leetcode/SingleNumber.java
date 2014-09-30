package com.zhquake.leetcode;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Sep 28, 2014
 */
public class SingleNumber {
    public class Solution {
        public int singleNumber(int[] A) {
            int x = 0;
            for (int item : A) {
                x = x ^ item;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        SingleNumber number = new SingleNumber();
        Solution solution = number.new Solution();
        System.out.println(solution.singleNumber(new int[] {
                1, 3, 4, 6, 1, 4, 6 }));

    }
}
