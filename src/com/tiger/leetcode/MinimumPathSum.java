package com.tiger.leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n= grid[0].length;
        int[][] dp = new int[m+1][n+1];
         for(int i = 2;i <= m;i++){dp[i][0] = Integer.MAX_VALUE;}
        for(int i = 2;i <= n;i++){dp[0][i] = Integer.MAX_VALUE;}
        for(int i = 1;i<=m;i++)
            for(int j=1;j<=n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        return dp[m][n];
    }
}
