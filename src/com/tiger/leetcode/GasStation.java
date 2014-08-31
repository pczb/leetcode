package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null) {
            return -1;
        }
        int count = gas.length;
        int n = 0, i = 0;
        int remain = 0, start = 0, end = 0;
        while (n < count - 1) {
            remain += gas[i] - cost[i];
            if (remain >= 0) {
                end++;
                i = end;
            } else {
                start--;
                if (start < 0) {
                    start = count - 1;
                }
                i = start;
            }
            n++;
        }

        remain += gas[i] - cost[i];

        if (remain >= 0) {
            return start;
        } else {
            return -1;
        }

    }
}
