package com.tiger.leetcode;

import java.util.ArrayList;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class PathSumTwo {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if(root == null) return res;
            findPath(root,new ArrayList<Integer>() ,sum,res,0);
            return res;

        }
        public void findPath(TreeNode root,ArrayList<Integer> path,int sum,ArrayList<ArrayList<Integer>> res,int tmpSum){

            if(root.left == null && root.right == null){
                if(tmpSum + root.val == sum){
                    ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                    tmp.add(root.val);
                    res.add(tmp);
                }
            }
            if(root.left != null) {
                path.add(root.val);
                findPath(root.left,path,sum,res,tmpSum + root.val);
                path.remove(path.size()-1);
            }
            if(root.right != null){
                path.add(root.val);
                findPath(root.right,path,sum,res,tmpSum + root.val);
                path.remove(path.size()-1);
            }

        }
    }
}
