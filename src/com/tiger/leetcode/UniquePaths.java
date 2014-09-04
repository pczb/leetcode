package com.tiger.leetcode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++)
            dp[i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
               dp[j] = dp[j - 1] + dp[j]; 
            }
        }
        return dp[n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) 
            return 0;
        int[] dp = new int[n];

        dp[0] = obstacleGrid[0][0] == 0 ? 1: 0;
        if(dp[0] == 0) return 0;
        for(int i = 1; i < n; i++)
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        
        for(int i = 1; i < m; i++){
            dp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n - 1];
    }
    public int baseLine(int m, int n) {
        int result[][] = new int[m][n];
        for(int i=0;i<n;i++){
            result[m-1][i] = 1;
        }
        for(int i=0;i<m;i++){
            result[i][n-1] = 1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                result[i][j] = result[i+1][j]+result[i][j+1];
            }
        }
        return result[0][0];
        
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int[][] matrix = {{0, 0 , 0},{0, 1 , 0},{0, 0 , 0}};
        System.out.println(solution.uniquePathsWithObstacles(matrix));
        System.out.println(solution.uniquePathsWithObstacles(new int[0][0]));
    }
}
