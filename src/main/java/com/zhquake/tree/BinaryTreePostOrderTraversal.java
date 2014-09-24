package com.zhquake.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.zhquake.leetcode.common.TreeNode;

public class BinaryTreePostOrderTraversal {
    public static List<Integer> traverseWithRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        result.addAll(traverseWithRecursive(root.left));
        result.addAll(traverseWithRecursive(root.right));
        result.add(root.val);

        return result;

    }

    public static List<Integer> traverseWithIterative1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode previsited = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            // In post-order, the root of a tree will be visited at last, and
            // root's children are the also roots of the child trees. So a root
            // and its children will be visited closely.
            if ((cur.left == null && cur.right == null)
            // notice that previsited may be null
                    || (previsited == cur.left || previsited == cur.right)) {
                result.add(cur.val);
                previsited = cur;
                stack.pop();
            } else {
                if (cur.right != null) {
                    stack.add(cur.right);
                }

                if (cur.left != null) {
                    stack.add(cur.left);
                }
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
        TreeNode previsited = root;
        while (!parentStack.isEmpty() || cur != null) {
            if (cur != null) {
                parentStack.push(cur);
                cur = cur.left;
            } else {
                cur = parentStack.peek();
                if (cur.right != null && cur.right != previsited) {
                    cur = cur.right;
                } else {
                    result.add(cur.val);
                    previsited = cur;
                    parentStack.pop();
                    cur = null;
                }
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
