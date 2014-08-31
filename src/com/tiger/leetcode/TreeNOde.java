package com.tiger.leetcode;

import apple.laf.JRSUIUtils;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = right = null;
    }

}
class TreeNodeHelper{
    public static TreeNode buildTree(int[] array, int index){
        if(index >= array.length) return null;
        if(array[index] == -1) return null;
        TreeNode head = new TreeNode(array[index]);
        head.left = buildTree(array, index * 2);
        head.right = buildTree(array, index*2+1);
        return head;
    }


    public static void preTraverse(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }
}
