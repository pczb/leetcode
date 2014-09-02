package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        dfs(n, sub, 1, k, ans);
        return ans;

    }

    public void dfs(int n, ArrayList<Integer> result, int step, int need, List<List<Integer>> results) {
        if (n - step < need - 1) return;
        if (need == 0) {
            ArrayList<Integer> path = new ArrayList<Integer>(result);
            results.add(path);
            return;
        }
        dfs(n, result, step + 1, need, results);
        result.add(step);
        dfs(n, result, step + 1, need - 1, results);
        result.remove(result.size() - 1);

    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        for(List<Integer> list: solution.combine(4, 3))
            Util.printList(list);
    }
}
