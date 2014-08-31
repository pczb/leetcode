package com.tiger.leetcode;

import java.util.List;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0 ; i--) {
            List<Integer> tmp = triangle.get(i);
            for(int j = 0; j <= i; j++){
                if(dp[j] <= dp[j+1]) dp[j] = dp[j] + triangle.get(i).get(j) ;
                else dp[j] = dp[j + 1] + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
