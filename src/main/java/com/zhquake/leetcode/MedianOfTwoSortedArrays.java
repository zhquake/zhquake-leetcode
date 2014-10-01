package com.zhquake.leetcode;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * @author zhen
 *
 */
public class MedianOfTwoSortedArrays {
	public class Solution {
		public double findMedianSortedArrays(int A[], int B[]) {
			int length = A.length + B.length;
			if (length % 2 == 0) {
				return (findKthValue(A, 0, B, 0, length / 2) + findKthValue(A,
						0, B, 0, length / 2 + 1)) / 2.0;
			} else {
				return findKthValue(A, 0, B, 0, length / 2 + 1);
			}
		}

		private int findKthValue(int A[], int firstA, int B[], int firstB, int k) {
			if (firstA >= A.length)
				return B[k - 1];

			if (firstB >= B.length)
				return A[k - 1];

			if (k == 1)
				return Math.min(A[firstA], B[firstB]);

			if (A.length > B.length)
				return findKthValue(B, firstB, A, firstA, k);

			int partA = Math.min(A.length, k / 2);
			int partB = k - partA;

			if (A[firstA + partA - 1] > B[firstB + partB - 1]) {
				return findKthValue(A, firstA, B, firstB + partB, k - partB);
			} else if (A[firstA + partA - 1] < B[firstB + partB - 1]) {
				return findKthValue(A, firstA + partA, B, firstB, k - partA);
			} else {
				return A[firstA + partA - 1];
			}
		}
	}
}
