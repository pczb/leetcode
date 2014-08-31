package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class MinDepthOfBTree {
    public class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            if(root.left != null)
                left = minDepth(root.left);
            if(root.right != null)
                right = minDepth(root.right);
            return left < right ? (left + 1) : (right + 1);

        }
    }
}
