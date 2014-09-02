package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class BalancedBinaryTree {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getHeigth(root);
        return flag;
    }

    private int getHeigth(TreeNode root) {
        int left = 0, right = 0;
        if(!flag) return -1;
        if(root.left == null && root.right == null) return 1;
        if(root.left != null) left = getHeigth(root.left);
        if(root.right != null) right = getHeigth(root.right);
        if(Math.abs(left - right) > 1) flag = false;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        TreeNode root = TreeNodeHelper.buildTree(new int[]{1,-1,3,-1,-1,4}, 0);
        System.out.println(binaryTree.isBalanced(root));
    }
}
