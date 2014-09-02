package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
    }

    private int getHeigth(TreeNode root) {
        int left = 0, right = 0;
        if(root.left == null && root.right == null) return 1;
        if(root.right left = getHeigth(root.left);
        int right = getHeigth(root.right);
    }
}
