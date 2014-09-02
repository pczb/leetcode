package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class FlattenTreeToList {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode head = new TreeNode(0);
        flatten(head, root);
    }

    TreeNode flatten(TreeNode prev, TreeNode root) {

        prev.right = root;
        TreeNode right = root.right;
        TreeNode left = root.left;

        root.left = null;

        prev = root;
        if (left != null) {
            prev = flatten(root, left);
        }
        if (right != null) {
            prev = flatten(prev, right);
        }
        return prev;

    }
}
