package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int prev2  = 1;
        int prev1 = 2;
        for(int i = 3;i<n;i++){
            int tmp = prev1;
            prev1 = prev1+prev2;
            prev2 = tmp;
        }
        return prev1 + prev2;

    }
}
