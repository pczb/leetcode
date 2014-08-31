package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class Candy {
    public int candy(int[] ratings) {
        int N = ratings.length;
        if (N == 0) {
            return N;
        }
        int[] candy = new int[N];
        int sum = N;
        for (int i = 0, k = 1; i < N; i++) {
            if (i - 1 >= 0 && ratings[i] > ratings[i - 1]) {
                candy[i] = Math.max(k++, candy[i]);
            } else {
                k = 1;
            }
        }

        for (int i = N - 1, k = 1; i >= 0; i--) {
            if (i + 1 < N && ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(k++, candy[i]);
            } else {
                k = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
