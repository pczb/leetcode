package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class WordBreakTwo {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ans = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return ans;
        dfs(s, dict, 0, "", ans);
        return ans;
    }

    private void dfs(String s, Set<String> dict, int start, String pre, ArrayList<String> res) {
        if (start >= s.length()) {
            res.add(pre);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dict.contains(s.substring(start, i + 1))) {
                pre = pre == "" ? s.substring(start, i + 1) : pre + " " + s.substring(start, i + 1);
                dfs(s, dict, i + 1, pre + s.substring(start, i + 1), res);
            }
        }
    }
}
