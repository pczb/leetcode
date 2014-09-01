package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) {
            x = x ^ a;
        }
        return x;
    }
}
