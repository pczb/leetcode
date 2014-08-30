package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if((m + n) % 2 == 0) {
            return (findKthSortedArrays(A, B, 0, m - 1, 0, n - 1, (m + n) / 2) +
            findKthSortedArrays(A, B, 0, m - 1, 0, n - 1, (m + n) / 2 + 1)) / 2.0;
        }
        else return findKthSortedArrays(A, B, 0, m - 1, 0, n - 1, (m + n)/2 + 1);
    }

    private double findKthSortedArrays(int[] A, int[] B, int startA, int endA,
            int startB, int endB, int k) {
        if(startA > endA) return B[startB + k - 1];
        if(startB > endB) return A[startA + k - 1];
        if(k == 1) return Math.min(A[startA], B[startB]);

        int middleA = startA + (k >> 1) - 1;
        int middleB = startB + (k >> 1) - 1;



        if(middleA > endA) middleA = endA;
        if(middleB > endB) middleB = endB;

        if(A[middleA] <= B[middleB]) return findKthSortedArrays(A, B, middleA + 1, endA, startB, endB, k - (middleA - startA + 1));
        else  return findKthSortedArrays(A, B, startA, endA, middleB + 1, endB, k - (middleB - startB + 1));

    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
        int[] A = new int[]{1};
        int[] B = new int[]{1};
        System.out.println(solution.findMedianSortedArrays(A, B));
       // solution.baseLine(A, B);
    }
}
