package com.zhquake.leetcode;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 * 
 * @author zhen
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
	public class Solution {
		public int removeDuplicates(int[] A) {
			if(A.length==0){
				return 0;
			}
			
			int index =1;
			boolean twice = true;
			int cur = A[0];
			for(int i =1;i<A.length;i++){
				if(A[i]!= cur){
					A[index++] = A[i];
					cur = A[i];
					twice = true;
				}else{
					if(twice){
						A[index++] = A[i];
						twice = false;
					}
				}
			}
			return index;
		}
	}
}
