package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class SubSetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> pre = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num, pre, 0, results);
        return results;
    }

    private void dfs(int[] s, ArrayList<Integer> result, int step,
                     List<List<Integer>> results) {

        results.add(new ArrayList<Integer>(result));
        for(int i = step; i < s.length; i++) {
            if(i != step && s[i] == s[i - 1])
                continue;
            result.add(s[i]);
            dfs(s, result, i + 1, results);
            result.remove(result.size() - 1);
        }


    }

    public static void main(String[] args) {
        SubSetsTwo solution = new SubSetsTwo();
        List<List<Integer>> lists = solution.subsetsWithDup(new int[]{1, 2, 2});
        for(List<Integer> list: lists)
            Util.printList(list);
    }
}
