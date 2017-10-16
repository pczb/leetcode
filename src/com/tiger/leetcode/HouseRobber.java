package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/3/10.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int rob = 0;
        int norob = 0;
        for(int i = nums.length - 1; i >=0; i--){
            int a= nums[i] + norob;
            int b = Math.max(norob, rob);
            rob = a;
            norob = b;
        }
        return Math.max(rob, norob);
    }

    public int dorob(int[] nums){
        return 0;
    }
}
