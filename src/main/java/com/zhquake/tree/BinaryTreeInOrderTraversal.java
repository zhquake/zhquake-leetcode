package com.zhquake.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

public class BinaryTreeInOrderTraversal {
    public static List<Integer> traverseWithRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        result.addAll(traverseWithRecursive(root.left));
        result.add(root.val);
        result.addAll(traverseWithRecursive(root.right));

        return result;
    }

    public static List<Integer> traverseWithIterative1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // Use isLeftVisited to mark if cur's left child is already visited
        boolean isLeftVisited = false;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.left == null || isLeftVisited) {
                result.add(cur.val);
                stack.pop();
                isLeftVisited = true;
                if (cur.right != null) {
                    stack.push(cur.right);
                    isLeftVisited = false;
                }
            } else {
                stack.push(cur.left);
                isLeftVisited = false;
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
        // one push, one pop, only push cur node, not cur's child node
        while (!parentStack.isEmpty() || cur != null) {
            if (cur != null) {
                parentStack.push(cur);
                cur = cur.left;
            } else {
                cur = parentStack.pop();
                result.add(cur.val);
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
