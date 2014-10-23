package com.zhquake.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author Zhang, Zhen(zhezhang@microstrategy.com) Oct 14, 2014
 */
public class BinaryTreeLevelOrderTraversalII {
    public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            if (root == null)
                return result;

            Stack<List<TreeNode>> stack = new Stack<List<TreeNode>>();

            List<TreeNode> rootList = new ArrayList<TreeNode>();
            rootList.add(root);
            stack.add(rootList);

            while (true) {
                List<TreeNode> levelList = new ArrayList<TreeNode>();
                for (TreeNode node : stack.peek()) {
                    if (node.left != null)
                        levelList.add(node.left);

                    if (node.right != null)
                        levelList.add(node.right);
                }

                if (levelList.isEmpty())
                    break;
                else
                    stack.add(levelList);
            }

            while (!stack.isEmpty()) {
                List<Integer> levelResult = new ArrayList<Integer>();
                for (TreeNode node : stack.pop()) {
                    levelResult.add(node.val);
                }
                result.add(levelResult);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII traversal = new BinaryTreeLevelOrderTraversalII();
        Solution solution = traversal.new Solution();
        System.out.println(solution.levelOrderBottom(TreeNode.SAMPLE_TREE));
    }
}
