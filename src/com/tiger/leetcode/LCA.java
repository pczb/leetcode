package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/3/12.
 */
public class LCA {
    TreeNode p;
    TreeNode q;
    TreeNode lcaNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        find(root);
        return lcaNode;
    }

    class Status{
        public boolean findA;
        public boolean findB;
    }

    public Status find(TreeNode root){
        Status status = new Status();
        if(root == null){
            return status;
        }

        if(root == p){
            status.findA = true;
        }
        if(root == q){
            status.findB = true;
        }
        Status left = find(root.left);
        Status right = find(root.right);
        status.findA = status.findA || left.findA || right.findA;
        status.findB = status.findB || left.findB || right.findB;
        if(status.findA && status.findB){
            if(lcaNode == null){
                lcaNode = root;
            }
        }
        return status;
    }

    public static void main(String[] args) {
        LCA lca = new LCA();
        TreeNode root = TreeNodeHelper.buildTree(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}, 0);
        System.out.println(lca.lowestCommonAncestor(root, root.left.left, root.left.right.left));
    }
}
