package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNodeHelper.buildTree(new int[]{3, 2, 4, -1, -1, 1}, 0);
        TreeNodeHelper.preTraverse(root);
        TreeNodeHelper.inTraverse(root);
        System.out.println();

        for(int i: postorderTraversal(root)){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return ans;
        else stack.push(root);

        TreeNode prev = null, current;
        while(! stack.empty()) {

            current = stack.peek();
            if(current.left == null && current.right == null){
                ans.add(current.val);
                stack.pop();
                prev = current;
            }
            if(prev == null){
                while(current.left != null) {
                    stack.push(current.left);
                    current = current.left;
                }
            }
            if(prev == current.right){
                ans.add(current.val);
                prev = current;
                stack.pop();
            }
            if(prev == current.left){
                if(current.right == null){
                    ans.add(current.val);
                    stack.pop();
                    prev = current;
                }else{
                    stack.push(current.right);
                    prev = null;
                }

            }
        }
        return ans;
    }
}
