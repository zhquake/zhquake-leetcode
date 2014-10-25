package com.zhquake.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 15, 2014
 */

public class ValidPalindrome {
    public class Solution {
        public boolean isPalindrome(String s) {
            if (s == null)
                return false;

            int fromHead = 0;
            int fromEnd = s.length() - 1;
            while (true) {
                while (fromHead < s.length()
                        && !isAlphanumeric(s.charAt(fromHead))) {
                    fromHead++;
                }

                while (fromEnd >= 0 && !isAlphanumeric(s.charAt(fromEnd))) {
                    fromEnd--;
                }

                if (fromHead >= s.length() || fromEnd < 0)
                    return true;
                else if (Character.toLowerCase(s.charAt(fromHead)) == (Character
                        .toLowerCase(s.charAt(fromEnd)))) {
                    fromHead++;
                    fromEnd--;
                    continue;
                } else {
                    return false;
                }

            }
        }

        private boolean isAlphanumeric(char c) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0'
                    && c <= '9')
                return true;
            else
                return false;
        }

    }

    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        Solution solution = palindrome.new Solution();
        System.out.println(solution.isPalindrome("         "));
        System.out.println(solution
                .isPalindrome("A man, a plan, a canal: Panama"));

    }
}
