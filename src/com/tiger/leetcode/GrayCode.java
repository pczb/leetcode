package com.tiger.leetcode;

import java.util.ArrayList;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        int size = 1 << n;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            ret.add(i ^ (i >> 1));
        }
        return ret;
    }
}
