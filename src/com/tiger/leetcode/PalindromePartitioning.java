package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        boolean[][] dp = getDp(s);
        List<String> prev = new ArrayList<String>();
        List<List<String>> ans = new ArrayList<List<String>>();
        if(s == null) return ans;
        dfs(s, 0, prev, ans, dp);
        for(List<String> list: ans) {
            for(String t: list){
                System.out.print(t + " ");
            }
            System.out.println();
        }
        return ans;
    }


    private void dfs(String s, int index, List<String> prev, List<List<String>> ans, boolean[][] dp) {
        int len = s.length();
        if(index == len) {
            ans.add(new ArrayList<String>(prev));
            return;
        }
        for(int i = index; i < len; i++) {
            if(dp[index][i]) {
              //  System.out.println(s.substring(index, i + 1));
                prev.add(s.substring(index, i + 1));
                dfs(s, i + 1, prev, ans, dp);
                prev.remove(prev.size() - 1);
            }
        }

    }
    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        solution.partition("a");
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
