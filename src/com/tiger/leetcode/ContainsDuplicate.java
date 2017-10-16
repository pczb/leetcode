package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/3/11.
 */
public class ContainsDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1 || k <= 0 || t <= 0){
            return false;
        }

        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i < k; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            if(Math.abs(max - nums[i]) <= t || Math.abs(min - nums[i]) <= t){
                return true;
            }
        }
        return false;
    }
}
