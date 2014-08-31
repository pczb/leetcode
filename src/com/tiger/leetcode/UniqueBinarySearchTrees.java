package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+4];
        if(n == 0) return 0;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<= n; i++){
            for(int j = 0; j<= i-1;j++)
                dp[i] += dp[j]*dp[i-j-1];
        }
        return dp[n];
    }
}
