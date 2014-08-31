package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        String result = "";
        int len = strs.length;
        int i, j;
        if (len == 0) return "";
        for (j = 0; ; ++j) {
            for (i = 0; i < len; ++i)
                if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) break;
            if (i < len) break;
            result += strs[0].charAt(j);
        }
        return result;
    }
}
