package com.zhquake.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 15, 2014
 */
public class LongestCommonPrefix {
    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0)
                return "";

            String result = strs[0];
            for (int i = 0; i < strs.length; i++) {
                result = getCommonPrefix(result, strs[i]);
            }

            return result;
        }

        private String getCommonPrefix(String str1, String str2) {
            int len = str1.length() < str2.length() ? str1.length() : str2
                    .length();
            int index = -1;
            for (int i = 0; i < len; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    index = i;
                } else {
                    break;
                }
            }

            return str1.substring(0, index + 1);
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        Solution solution = prefix.new Solution();

        System.out.println(solution.longestCommonPrefix(new String[] {
                "abc", "ab", "adef" }));
    }
}
