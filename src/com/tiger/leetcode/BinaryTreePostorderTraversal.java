package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNodeHelper.buildTree(new int[]{1,2,3}, 0);
        for(int i: postorderTraversal(root)){
            System.out.print(i+" ");
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return ans;
        else stack.push(root);

        TreeNode prev = null, current;
        while(!stack.empty()) {

            current = stack.peek();
            if(current.left == null && current.right == null){
                ans.add(current.val);
                prev = current;
                stack.pop();
            }
            if(current.left == prev && current.right != null){
                stack.push(current.right);
            }else if((current.left == prev && current.right == null)|| current.right == prev){
                ans.add(current.val);
                prev = current;
                stack.pop();
            }
        }
        return ans;
    }
}
