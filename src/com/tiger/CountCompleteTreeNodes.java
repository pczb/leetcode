package com.tiger;

import com.tiger.leetcode.TreeNode;

/**
 * Created by tigerzhang on 16/3/11.
 */
public class CountCompleteTreeNodes {
    private int maxWidht = 0;
    private int maxDepth = 0;
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxDepth = 0;
        TreeNode tmp = root;
        while (tmp != null){
            tmp = tmp.left;
            maxDepth += 1;
        }
        maxWidht = (int)Math.pow(2, maxDepth - 1);
        return doCount(root, 1, 1);
    }


    public int doCount(TreeNode root, int depth, int width){
        if(depth == maxDepth){
            if(width == maxWidht){
                return (int)Math.pow(2, depth) - 1;
            }else {
                return -1;
            }
        }
        if(root.left == null){
            return (int)Math.pow(2, depth) + 2 * width - 3;
        }
        if(root.right == null){
            return (int)Math.pow(2, depth) + 2 * width - 2;
        }

        int left = doCount(root.left, depth + 1, 2 * width - 1);
        if(left != -1){
            return left;
        }
        return doCount(root.right, depth + 1, 2 * width);
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes so = new CountCompleteTreeNodes();
        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(1);
//        node.right = new TreeNode(2);
//        node.left.left = new TreeNode(2);
// node.left.right = new TreeNode(2);
        System.out.println(so.countNodes(node));
    }
}
