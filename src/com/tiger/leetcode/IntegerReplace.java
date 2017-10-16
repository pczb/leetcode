package com.tiger.leetcode;

/**
 * Created by tigerzhang on 2017/9/24.
 */
public class IntegerReplace {
    public static int integerReplacement(int n) {
        int step = 0;

        while (n > 1) {
            int oneBitCount = 0;

            while ((n & 1) == 1) {
                oneBitCount += 1;
                n = n >>> 1;
            }


            if (oneBitCount == 0) {
                step += 1;
                n = n >>> 1;
            } else {
                step += oneBitCount + 1;
                n = (n << 1) ^ 1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(12312312));
    }
}
