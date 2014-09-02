package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        return 1 + (maxL > maxR ? maxL : maxR);
    }
}
