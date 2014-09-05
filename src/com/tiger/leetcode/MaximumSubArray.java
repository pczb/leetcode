package com.tiger.leetcode;

public class MaximumSubArray {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        int preMax = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                if((preMax + A[i]) > max)
                    max = preMax + A[i];
            }
            preMax = preMax + A[i];
            if(preMax < 0) preMax = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2 , 1, -3,4,-1,2,1,-5,4};
        //int[] array = {1, 2};
        MaximumSubArray solution = new MaximumSubArray();
        System.out.println(solution.maxSubArray(array));
    }
        
}
