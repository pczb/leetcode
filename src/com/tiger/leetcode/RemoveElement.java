package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,2,3,4,5,2,4,5,6}, 2));
    }
    public static int removeElement(int[] A, int elem) {
        int i = 0;
        int index = -1;
        while( i <  A.length){
           if(A[i] != elem) A[++index] = A[i];
           i++;
        }
        return index + 1;
    }
}
