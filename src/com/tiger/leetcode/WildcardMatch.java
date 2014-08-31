package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 * <p/>
 * this is my sloution but time exceeds;
 */
public class WildcardMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("", ""));
        System.out.println(isMatch("ab", "ab*"));
        System.out.println(isMatch("b", "*?*?"));
        System.out.println(isMatch("ab", "a*b"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "a*a*b"));
        System.out.println(isMatch("caaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "caaaaaaaaaa*bc*aaaaaaa*"));
    }


    public static boolean isMatch(String query, String pattern) {
        if (query == null || pattern == null) return false;

        int m = pattern.length();
        int n = query.length();

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = pattern.length() - 1; i >= 0; i--) {
            if (pattern.charAt(i) != '*') {
                for (int j = 0; j < n; j++) {
                    dp[j] = dp[j + 1] && (query.charAt(j) == pattern.charAt(i) || pattern.charAt(i) == '?');
                }
                dp[n] = false;
            } else {
                int k;
                for (k = n; k >= 0; k--) {
                    if (dp[k]) break;
                }
                while (k >= 0) dp[k--] = true;
            }
        }
        return dp[0];
    }
}
