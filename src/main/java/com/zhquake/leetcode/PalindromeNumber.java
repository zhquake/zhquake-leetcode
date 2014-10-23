package com.zhquake.leetcode;

public class PalindromeNumber {
    public class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;

            int num = 1;
            while (x / num >= 10) {
                num = num * 10;
            }

            int cur = x;
            while (cur > 0) {
                int head = cur / num;
                int end = cur % 10;
                if (head != end)
                    return false;

                cur = cur % num / 10;
                num = num / 100;
            }

            return true;
        }
    }
}
