package com.zhquake.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

public class BinaryTreePreOrderTraversal {
    public static List<Integer> traverseWithRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        result.add(root.val);
        result.addAll(traverseWithRecursive(root.left));
        result.addAll(traverseWithRecursive(root.right));
        return result;
    }

    public static List<Integer> traverseWithIterative1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    public static List<Integer> traverseWithIterative2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!parentStack.isEmpty() || cur != null) {
            if (cur != null) {
                result.add(cur.val);
                parentStack.push(cur);
                cur = cur.left;
            } else {
                cur = parentStack.pop();
                cur = cur.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(traverseWithRecursive(TreeNode.SAMPLE_TREE));
        System.out.println(traverseWithIterative1(TreeNode.SAMPLE_TREE));
        System.out.println(traverseWithIterative2(TreeNode.SAMPLE_TREE));
    }
}
