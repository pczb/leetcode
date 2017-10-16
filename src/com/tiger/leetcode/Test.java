package com.tiger.leetcode;

import java.util.Stack;

/**
 * Created by tigerzhang on 14/9/24.
 */
public class Test {

    public static void main(String[] args) {
        TreeNode root = TreeNodeHelper.buildTree(new int[]{1,2,8,5,6,7,10}, 0);
        TreeNode pre = new TreeNode(1);
        inTraverse(root, pre);
        root = pre.right;
        while(root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    private static TreeNode inTraverse(TreeNode root, TreeNode pre) {

        if(root.left != null) pre = inTraverse(root.left, pre);

        root.left = pre;
        pre.right = root;
        pre = root;

        if(root.right != null)  pre = inTraverse(root.right, root);
        return pre;

    }

}
