package com.zhquake.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 15, 2014
 */
public class LengthOfLastWord {
    public class Solution {
        public int lengthOfLastWord(String s) {
            int result = 0;
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    if (cur != 0)
                        result = cur;
                    cur = 0;
                } else {
                    cur++;
                }
            }
            if (cur == 0)
                return result;
            else
                return cur;
        }
    }

    public static void main(String[] args) {
        LengthOfLastWord length = new LengthOfLastWord();
        Solution solution = length.new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}
