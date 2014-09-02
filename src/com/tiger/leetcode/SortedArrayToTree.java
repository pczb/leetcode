package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class SortedArrayToTree {
    public TreeNode sortedArrayToBST(int[] num) {
        int lenght = num.length;
        return buildTree(num,0,num.length-1);
    }
    public TreeNode buildTree(int[] num,int start,int end){
        if (start > end) return null;
        int middle = (start+end)/2;
        TreeNode root = new TreeNode(num[middle]);
        root.left = buildTree(num,start,middle-1);
        root.right = buildTree(num,middle+1,end);
        return root;
    }
}
