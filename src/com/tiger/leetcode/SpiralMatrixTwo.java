package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/5.
 */
public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n == 0) return res;
        int level = n / 2;
        if(level == 0)
        {
            res[0][0] = 1;
            return res;
        }
        int cnt = 1;
        for(int i = 0; i < level; i++)
        {
            for(int j = i; j < n - i; j++)
            {
                res[i][j] = cnt++;
            }
            for(int j = i; j < n - i; j++)
            {
                if(res[j][n-i-1] != 0)
                    continue;
                res[j][n-i-1] = cnt++;
            }
            for(int j = n-1-i; j >= 0; j--)
            {
                if(res[n-1-i][j] != 0)
                    continue;
                res[n-1-i][j] = cnt++;
            }
            for(int j = n-1-i; j >= 0; j--)
            {
                if(res[j][i] != 0)
                    continue;
                res[j][i] = cnt++;
            }
        }
        if(n % 2 == 1)
        {
            res[n / 2][n / 2] = cnt;
        }
        return res;
    }
}
