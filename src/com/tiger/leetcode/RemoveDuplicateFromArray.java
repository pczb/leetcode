package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class RemoveDuplicateFromArray {
    public class Solution {
        public int removeDuplicates(int[] A) {
            if (A.length == 0) return 0;
            int start = 0;
            int i = 1;
            while (i < A.length) {
                if (A[start] != A[i])
                    A[++start] = A[i];
                i++;
            }
            return start + 1;
        }
    }
}
