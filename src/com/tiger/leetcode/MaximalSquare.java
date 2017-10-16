package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/3/11.
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int ret = 0;
        for(int i = 0; i < m; i++){
            if(matrix[n - 1][i] == '1'){
                dp[n-1][i] = 1;
                ret = 1;
            }

        }
        for(int i = 0; i < n; i++){
            if(matrix[i][m-1] == '1'){
                dp[i][m-1] = 1;
                ret = 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = m - 2; j >= 0; j--){
                if(matrix[i][j] != '0' && dp[i + 1][j + 1] != 0){
                    if(dp[i + 1][j] !=0 && dp[i][j + 1] != 0){
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][ j + 1]);
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j+1]) + 1;
                        ret = Math.max(ret, dp[i][j] * dp[i][j]);
                    }
                }
                if(matrix[i][j] == '1' && dp[i][j] == 0){
                    dp[i][j] = 1;
                }

            }
        }

        return ret;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"11111111","11111110","11111110","11111000","01111000"};
        char[][] a = new char[input.length][input[0].length()];
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[0].length(); j++){
                a[i][j] = input[i].charAt(j);
            }
        }
        System.out.println(maximalSquare(a));
    }
}
