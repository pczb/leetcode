package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ReverseInteger {
    public int reverse(int x) {
        long remain = Math.abs(x);
        long ans = 0;
        while(remain != 0){
            ans = ans * 10 + remain % 10;
            remain = remain / 10;
        }
        if(x < 0){
            if((0 - ans) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            ans = 0 - ans;
        }
        if(x > 0){
            if(x > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return (int)ans;
    }
}
