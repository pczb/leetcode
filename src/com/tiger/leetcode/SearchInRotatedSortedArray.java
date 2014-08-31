package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null) return -1;
        int start, end, middle;
        start = 0;
        end = A.length - 1;
        while (start <= end) {
            middle = (end + start) / 2;
            if (A[middle] == target)
                return middle;
            if (A[start] <= A[middle]) {
                if (A[start] <= target && A[middle] > target) {
                    end = middle - 1;
                } else start = middle + 1;
            } else {
                if (A[middle] < target && A[end] >= target)
                    start = middle + 1;
                else
                    end = middle - 1;
            }
        }
        return -1;
    }
}
