package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class BinaryTreeMaximumPathSum {
    private  int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(-10);
        root.left.right = new TreeNode(-20);

    }

    public  int maxPathSum(TreeNode root){
        traverse(root);
        return maxVal;
    }
    public  int traverse(TreeNode root) {
        if(root == null) return 0;
        int left = 0, right = 0;
        if(root.left != null) left = traverse(root.left);
        if(root.right != null) right = traverse(root.right);

        if(left < 0) left = 0;
        if(right < 0) right = 0;
        maxVal = Math.max(maxVal, root.val + left);
        maxVal = Math.max(maxVal, root.val + right);
        maxVal = Math.max(maxVal, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
