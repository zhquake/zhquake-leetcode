package com.zhquake.leetcode;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 15, 2014
 */
public class ReverseInteger {
    public class Solution {
        public int reverse(int x) {
            int result = 0;
            int cur = Math.abs(x);
            while (cur >= 10) {
                int tmp = cur % 10;
                result = result * 10 + tmp;
                cur = cur / 10;
            }
            result = result * 10 + cur;
            if (x < 0)
                return 0 - result;
            else
                return result;
        }
    }
}
