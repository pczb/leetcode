package com.tiger.leetcode;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by tigerzhang on 16/6/7.
 */
public class CountingBits {
    public int[] countBits(int num) {
        return new int[]{};
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = Maps.newHashMap();
        map.put(null, 1);
        System.out.println(map.containsKey(null));
        System.out.println(map.get(null));

        map.put(1, null);
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
    }
}
