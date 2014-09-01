package com.tiger.leetcode;

import java.util.Stack;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class SumRootLeafNumbers {


    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> preValStack = new Stack<Integer>();
        if (root != null) stack.push(root);
        preValStack.push(0);
        int pre;

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            pre = preValStack.pop();

            while (node.left != null) {
                pre = pre * 10 + node.val;
                if(node.right != null){
                    stack.push(node.right);
                    preValStack.push(pre);
                }
                node = node.left;
            }
            if(node.right != null) {
                stack.push(node.right);
                preValStack.push(pre * 10 + node.val);
            }
            else if (node.left == null && node.right == null) {
             //   System.out.println(pre * 10 + node.val);
                sum += pre * 10 + node.val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeHelper.buildTree(new int[]{9}, 0);
//        TreeNodeHelper.inTraverse(root);
        System.out.println(sumNumbers(root));
    }
}
