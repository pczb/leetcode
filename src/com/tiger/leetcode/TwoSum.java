package com.tiger.leetcode;

import java.util.HashMap;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] res = sum.twoSum(new int[]{1, 2, 3}, 3);
        Util.printIntArray(res);
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        int[] res = new int[2];
        int index = 1;
        for (int num : numbers) {
            int need = target - num;
            if (map.containsKey(num)) {
                res[0] = map.get(num);
                res[1] = index;
                break;
            }
            map.put(need, index);
            index += 1;
        }
        return res;
    }
}
