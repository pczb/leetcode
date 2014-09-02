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

    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int pre = A[0];
        int index = 0, count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == pre)
                count ++;
            else{
                System.out.println(count +" "+pre);
                A[index++] = pre;
                if(count >= 2)
                    A[index++] = pre;
                pre = A[i];
                count = 1;
            }
        }
        A[index++] = pre;
        if(count >= 2) A[index++] = pre;
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromArray solution = new RemoveDuplicateFromArray();
        int[] array = new int[]{1, 2};
        System.out.println(solution.removeDuplicates(array));
        Util.printIntArray(array);
    }
}
