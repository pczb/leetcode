package com.tiger.leetcode;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * Created by tigerzhang on 16/2/4.
 */
public class NumSquares {
    static class Solution {
        public int numSquares(int n) {
            int max_len = (int)Math.sqrt(n);
            int[] constant = new int[max_len];
            int[] dp = new int[n + 1];
            for(int i = 1; i <= max_len; i++){
                constant[i - 1] = i * i;
            }
            return dfs(constant, dp, 0, 0, n);
        }

        public int calc(int[] dp, int n){
//            for(int i = 1; i < n; i++){
//                dp[i] = calc(dp, i);
//            }
//            return calc(dp, n);

            if(dp[n] == 1){
                return 1;
            }
            if(dp[n-1] == 1){
                return 2;
            }

            int min = Integer.MAX_VALUE;
            for(int i = 1; i < n; i++){
                if(dp[i] + dp[n -i] < min){
                    min = dp[i] + dp[n-i];
                }
            }
            return min;
        }

        public int dfs(int[] numbers, int dp[],int idx, int step, int remain){
            if(remain == 0 || dp[remain] != 0){
                return step;
            }

            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;

            if(remain - numbers[idx] >= 0) {
                if(dp[remain - numbers[idx]] != 0){
                    a = dp[remain - numbers[idx]];
                }else {
                    a = dfs(numbers, dp, idx, step + 1, remain - numbers[idx]);
                }
            }
            if(idx < numbers.length - 1 && remain - numbers[idx + 1] >= 0){
                if(dp[remain - numbers[idx + 1]] != 0){
                    a = dp[remain - numbers[idx + 1]];
                }else {
                    a = dfs(numbers, dp, idx + 1, step + 1, remain - numbers[idx + 1]);
                }
            }
            dp[remain] = a < b ? a:b;
            return a < b? a:b;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(123));
    }
}
