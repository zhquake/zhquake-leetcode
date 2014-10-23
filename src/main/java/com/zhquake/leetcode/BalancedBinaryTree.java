package com.zhquake.leetcode;

import com.zhquake.leetcode.common.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 16, 2014
 */
public class BalancedBinaryTree {
    public class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            if (isBalanced(root.left) && isBalanced(root.right)) {
                int leftHeight = getHeight(root.left);
                int rightHeight = getHeight(root.right);
                if (Math.abs(leftHeight - rightHeight) <= 1)
                    return true;
            }
            return false;
        }

        private int getHeight(TreeNode root) {
            if (root == null)
                return 0;
            else {
                return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
            }
        }
    }
}
