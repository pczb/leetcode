package com.tiger.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tigerzhang on 16/5/21.
 */
public class BuildRecersive {
    public static int solve(char[] array, int start, int end, int[][] dp){
        if(end < start){
            dp[start][end] = 0;
            return 0;
        }
        if(end == start){
            dp[start][end] = 1;
            return 1;
        }

        if(dp[end][start] != 0){
            return dp[start][end];
        }

        int without = solve(array, start + 1, end, dp);
        int with = 0;
        while(end > start && array[start] != array[end]){
            end--;
        }
        if(end > start){
            with =  2 + solve(array, start + 1, end - 1, dp);
        }
        dp[start][end] = with > without? with: without;
        return dp[start][end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line.length() - solve(line.toCharArray(), 0, line.length() - 1, new int[line.length()][line.length()]));
        }
    }
}
