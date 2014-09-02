package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class SortColor {
    public static void main(String[] args) {
        SortColor solution = new SortColor();
        int[] array = {1, 1, 1, 2, 2, 3, 3, 3, 3, 1, 1, 1, 2, 3};
        solution.sortColors(array);
        Util.printIntArray(array);
    }

    public void sortColors(int[] A) {
        int len = A.length;
        int i = 0, j = len - 1;
        while(i < j){
            while(i < j && A[i] == 0) i++;
            while(j > i && A[j] != 0) j--;
            if(i < j){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        j = len-1;
        while(i < j){
            while(A[i] == 1 && i< j) i++;
            while(A[j] != 1 && j>i) j--;
            if(i < j){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

    }
}
