package com.zhquake.leetcode;

import com.zhquake.leetcode.common.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 16, 2014
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0)
                return null;

            return constructSubTree(preorder, 0, preorder.length - 1, inorder,
                    0, inorder.length - 1);

        }

        TreeNode constructSubTree(int[] preorder, int preBegin, int preEnd,
                int[] inorder, int inBegin, int inEnd) {
            int rootValue = preorder[preBegin];
            int rootIndex = find(inorder, rootValue);
            if (rootIndex == -1 || rootIndex < inBegin || rootIndex > inEnd)
                return null;

            TreeNode root = new TreeNode(rootValue);

            if (rootIndex != inBegin) {
                root.left = constructSubTree(preorder, preBegin + 1, preBegin
                        + rootIndex - inBegin - 1, inorder, inBegin,
                        rootIndex - 1);
            }

            if (rootIndex != inEnd) {
                root.right = constructSubTree(preorder, preBegin + rootIndex
                        - inBegin + 1, preEnd, inorder, rootIndex + 1, inEnd);
            }

            return root;
        }

        private int find(int[] values, int value) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] == value)
                    return i;
            }

            return -1;
        }
    }
}
