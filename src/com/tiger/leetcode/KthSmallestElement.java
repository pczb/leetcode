package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/3/12.
 */
public class KthSmallestElement {
    static TreeNode ret;
    public static int kthSmallest(TreeNode root, int k) {
        size(root, k);
        return ret.val;
    }

    public static int size(TreeNode root, int k){
        if(root == null || ret != null){
            return 0;
        }
        int left = size(root.left, k);
        if(left == k -1){
            ret = root;
        }
        int right = size(root.right, k - left - 1);
        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(5);
//        root.left.right = new TreeNode(7);
//        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(2);
        System.out.println(kthSmallest(root, 2));
    }

}
