package com.tiger.leetcode;

import java.util.ArrayList;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class PathSum {
    public boolean pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return false;
        findPath(root, new ArrayList<Integer>(), sum, res, 0);
        if(res.size() != 0) return true;
        return false;

    }

    public void findPath(TreeNode root, ArrayList<Integer> path, int sum, ArrayList<ArrayList<Integer>> res, int tmpSum) {

        if (root.left == null && root.right == null) {
            if (tmpSum + root.val == sum) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                tmp.add(root.val);
                res.add(tmp);
            }
        }
        if (root.left != null) {
            path.add(root.val);
            findPath(root.left, path, sum, res, tmpSum + root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            findPath(root.right, path, sum, res, tmpSum + root.val);
            path.remove(path.size() - 1);
        }

    }
}
