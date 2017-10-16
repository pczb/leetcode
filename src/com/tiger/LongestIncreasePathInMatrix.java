package com.tiger;

/**
 * Created by tigerzhang on 16/3/8.
 */
public class LongestIncreasePathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = -1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                solve(matrix, dp, i, j);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private int solve(int[][] matrix, int[][] dp, int i, int j){
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int ret = 1;
        if(i + 1 < matrix.length && matrix[i+1][j] > matrix[i][j]){
            ret = Math.max(ret, 1 + solve(matrix, dp, i + 1, j));
        }
        if(i - 1 >= 0 && matrix[i-1][j] > matrix[i][j]){
            ret = Math.max(ret, 1 + solve(matrix, dp, i - 1, j));
        }
        if(j - 1 >= 0 && matrix[i][j-1] > matrix[i][j]){
            ret = Math.max(ret, 1 + solve(matrix, dp, i, j - 1));
        }
        if(j + 1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]){
            ret = Math.max(ret, 1 + solve(matrix, dp, i, j + 1));
        }
        dp[i][j] = ret;
        return dp[i][j];
    }
}
