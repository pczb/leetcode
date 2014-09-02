package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class BinaryTreeInorder {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        while(stack.size() > 0){
            TreeNode node = stack.pop();
            ans.add(node.val);
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return ans;
    }
}
