package com.tiger.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tigerzhang on 2016/8/20.
 */
public class RansomeNote {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        return doBuild(preorder, 0, preorder.length - 1, inorder, 0);
    }

    public static TreeNode doBuild(int[] inorder, int start, int end, int[] preorder, int idx){
        TreeNode root = null;
        for(int i = start; i <= end; i++){
            if(preorder[i] == inorder[idx]){
                root = new TreeNode(preorder[i]);
                root.left = doBuild(preorder, start, i - 1, inorder, idx + 1);
                root.right = doBuild(preorder, i + 1, end, inorder, idx + (i - start) + 1);
            }
        }
        return root;

    }


    public static void main(String[] args) {
        int[] prev = new int[]{1,2,4,5,3};
        int[] in = new int[]{4,2,5,1,3};
        TreeNodeHelper.inTraverse(buildTree(prev, in));
    }
}
