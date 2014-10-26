package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.zhquake.leetcode.common.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 15, 2014
 */
public class BinaryTreeLevelOrderTraversal {
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
            traverse(root, 1, result);
            return result;
        }

        private void traverse(TreeNode root, int level,
                List<List<Integer>> result) {
            if (root == null)
                return;

            if (level > result.size()) {
                result.add(new ArrayList<Integer>());
            }

            result.get(level - 1).add(root.val);
            traverse(root.left, level + 1, result);
            traverse(root.right, level + 1, result);
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        Solution solution = traversal.new Solution();
        System.out.println(solution.levelOrder(TreeNode.SAMPLE_TREE));
    }
}
