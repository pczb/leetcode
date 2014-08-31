package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root,Integer.MAX_VALUE,Integer.MIN_VALUE);

    }
    private boolean isValid(TreeNode root,int max,int min){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isValid(root.left,root.val,min)?isValid(root.right,max,root.val):false;
    }
}
