package com.tiger.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        for(; i >=0 && j >= 0; index--) {
            if(A[i] >= B[j]) {
                A[index] = A[i];
                i--;
            }
            else{
                A[index] = B[j];
                j--;
            }
        }
        while(i >= 0) A[index--] = A[i--];
        while(j >= 0) A[index--] = B[j--];
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] a = new int[4];
        int[] b = new int[4];
        Random random = new Random();
        for(int i = 0; i < 4; i++) {
            a[i] = random.nextInt(200);
            b[i] = random.nextInt(200);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Util.printIntArray(a);
        Util.printIntArray(b);
        solution.merge(a, 0, b, 2);
        Util.printIntArray(a);
    }
}
