package com.zhquake.leetcode;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 15, 2014
 */
public class RomanToInteger {
    public class Solution {
        public int romanToInt(String s) {
            if (s == null || s.length() == 0)
                return 0;
            if (s.length() == 1)
                return getNum(s.charAt(0));

            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() - 1
                        && getNum(s.charAt(i)) < getNum(s.charAt(i + 1))) {
                    result = result + getNum(s.charAt(i + 1))
                            - getNum(s.charAt(i));
                    i++;
                } else {
                    result += getNum(s.charAt(i));
                }
            }

            return result;
        }

        private int getNum(char roman) {
            switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        RomanToInteger integer = new RomanToInteger();
        Solution solution = integer.new Solution();
        System.out.println(solution.romanToInt("IV"));
    }
}
