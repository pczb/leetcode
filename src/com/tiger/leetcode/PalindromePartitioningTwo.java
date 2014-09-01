package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class PalindromePartitioningTwo {
    public static int minCut(String s) {
        boolean[][] isPal = getDp(s);
        int[] dp = new int[s.length() + 1];
        int len = s.length();
        for(int i = 0; i <= len; i++) dp[i] = i;
        for(int i = 0; i < len; i++) {
            for(int j = i; j >= 0; j--) {
                if(isPal[j][i]){
                    dp[i + 1] = Math.min(dp[j] + 1, dp[i + 1]);
                }
            }
        }
        return dp[len] - 1;
    }

    public static void main(String[] args) {
        System.out.println(minCut("abacbc"));
    }

    private static boolean[][] getDp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i; j++){
                if(i == j) dp[i][j] = true;
                else if(j == i - 1) dp[j][i] = (s.charAt(i) == s.charAt(j));
                else if(s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1]) dp[j][i] = true;
                else dp[j][i] = false;
                //     System.out.println(dp[j][i] + " "+ j +" "+i);
            }
        }
        return dp;
    }
}
