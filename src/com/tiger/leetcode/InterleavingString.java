package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class InterleavingString {
    public  boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 1;
        for(int i = 0; i < s1.length(); i++){
            if(dp[i][0] == 1 && s1.charAt(i) == s3.charAt(i)) dp[i+1][0] = 1;
        }
        for(int j = 0; j < s2.length(); j++){
            if(dp[0][j] == 1 && s2.charAt(j) == s3.charAt(j)) dp[0][j+1] = 1;
        }
        for(int i = 1; i <= s1.length(); i++)
            for(int j = 1; j <= s2.length(); j++){
                if(dp[i-1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) dp[i][j] = 1;
                else if(dp[i][j-1] == 1 && s2.charAt(j -1) == s3.charAt(i + j -1)) dp[i][j] = 1;
            }
        return dp[s1.length()][s2.length()] == 1;
    }
}
