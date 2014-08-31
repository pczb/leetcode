package com.tiger.leetcode;

import java.util.Arrays;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest sum = new ThreeSumClosest();
        System.out.println(sum.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));

        System.out.println(sum.baseLine(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }

    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) return -1;
        Arrays.sort(num);
        int min = num[0] + num[1] + num[2];

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                int sum = num[i] + num[j];
                //   if(sum > min) break;
                int closestVal = findClosest(num, j + 1, num.length - 1, target - sum);
                if (Math.abs(num[i] + num[j] + closestVal - target) < Math.abs(min - target)) {
                    min = num[i] + num[j] + closestVal;
                }
            }
        }
        return min;
    }

    public int baseLine(int[] num, int target) {
        Arrays.sort(num);
        int numSize = num.length;
        if (numSize < 3) return -1;

        int minMargin = num[0] + num[1] + num[2] - target;

        int curMargin = 0;
        for (int i = 0; i <= numSize - 3; ++i) {
            int j;
            int k;
            for (j = i + 1, k = numSize - 1; j < k; ) {
                curMargin = num[i] + num[j] + num[k] - target;
                if (curMargin == 0) return target;
                if (Math.abs(curMargin) < Math.abs(minMargin)) minMargin = curMargin;
                if (curMargin < 0) j++;
                else k--;
            }
        }
        return minMargin + target;
    }

    public int findClosest(int[] num, int start, int end, int key) {
        if (key <= num[start]) return num[start];
        if (key >= num[end]) return num[end];
        if (start > end) {
            if (key - num[end] < num[start] - key) return num[end];
            else return num[start];
        }

        int middle = start + (end - start >> 1);
        if (num[middle] == key) return num[middle];
        if (num[middle] > key) return findClosest(num, start, middle - 1, key);
        return findClosest(num, middle + 1, end, key);

    }
}
