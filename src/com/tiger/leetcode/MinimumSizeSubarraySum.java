package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/3/10.
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int curSum = 0;
        int min_step = nums.length + 1;

        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            if(curSum >= s){
                min_step = Math.min(i - start + 1, min_step);
                while (start < i && curSum - nums[start] >= s ){
                    curSum -= nums[start];
                    start++;
                    min_step = Math.min(i - start + 1, min_step);
                }
            }
        }
        return min_step == nums.length + 1? 0: min_step;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(10, nums));
    }
}
