package com.zhquake.leetcode;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Sep 29, 2014
 */
public class Candy {
    public class Solution {
        public int candy(int[] ratings) {
            if (ratings.length == 0)
                return 0;

            if (ratings.length == 1)
                return 1;

            int sum = 0;
            int lastLeastCandy = 1;

            for (int i = 0; i < ratings.length;) {
                int j = i;
                int curLeastCandy = 1;
                for (; j < ratings.length - 1; j++) {
                    if (ratings[j] > ratings[j + 1]) {
                        curLeastCandy++;
                    } else {
                        break;
                    }
                }
                int count = j - i;
                i = j + 1;
                if (curLeastCandy > lastLeastCandy) {
                    lastLeastCandy = curLeastCandy;
                }
                sum += (2 * lastLeastCandy - count) * (count + 1) / 2;

                if (j + 1 < ratings.length && ratings[j + 1] > ratings[j]) {
                    lastLeastCandy = lastLeastCandy - count + 1;
                } else {
                    lastLeastCandy = 1;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        Solution solution = candy.new Solution();
        System.out.println(solution.candy(new int[] {
                3, 2 }));
    }
}
