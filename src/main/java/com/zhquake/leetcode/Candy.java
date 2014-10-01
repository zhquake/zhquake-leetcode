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
		// time: O(n) space:O(1)
		public int candy(int[] ratings) {
			if (ratings.length == 0)
				return 0;

			if (ratings.length == 1)
				return 1;

			int sum = 0;
			int lastLeast = 0;
			
			for (int i = 0; i < ratings.length;) {
				int j = i;
				for (; j < ratings.length - 1; j++) {
					if (ratings[j] <= ratings[j + 1]) {
						break;
					}
				}
				int count = j - i + 1;

			int blockFirstCandyMin;
				if (i - 1 < 0 || ratings[i] == ratings[i - 1]) {
					blockFirstCandyMin = 1;
				} else {
					blockFirstCandyMin = lastLeast +1;
				}

				if (count >= blockFirstCandyMin) {
					sum += (count + 1) * count / 2;
				} else {
					sum = sum + blockFirstCandyMin;
					sum += (count) * (count - 1) / 2;
				}

				if(count == 1){
					lastLeast = blockFirstCandyMin;
				}else{
					lastLeast = 1;
				}
				
				i = i + count;
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		Candy candy = new Candy();
		Solution solution = candy.new Solution();
		System.out.println(solution.candy(new int[] { 3, 2 }));
		System.out.println(solution.candy(new int[] { 2, 3, 2 }));
		System.out.println(solution.candy(new int[] { 1, 3, 5 }));
	}
}
