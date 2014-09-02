package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left == null || right == null) return false;
        else if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree solution = new SymmetricTree();
        TreeNode root = TreeNodeHelper.buildTree(new int[]{1, 2, 2, -1, -1, -1, 0}, 0);
        System.out.println(solution.isSymmetric(root));
    }
}
