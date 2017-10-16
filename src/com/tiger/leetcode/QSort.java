package com.tiger.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tigerzhang on 16/5/27.
 */
public class QSort {
    private static int[] getRandomArray(int arrayLength, int maxNum){
        int[] array = new int[arrayLength];
        for(int i=0;i<array.length;i++){
            array[i] = (int)(Math.random()*maxNum);
        }
        return array;
    }

    public void qsort(int[] array){
        if(array == null){
            return;
        }
        qsort(array, 0, array.length - 1);

    }

    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void qsort(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int tmp = start;
        int tmp1 = end;
        int flag = array[start];
        while (start < end) {
            while (start < end && array[end] >= flag) {
                end--;
            }
            if (start < end) {
                array[start++] = array[end];
            }

            while (start < end && array[start] <= flag) {
                start++;
            }
            if (start < end) {
                array[end--] = array[start];
            }
        }
        array[start] = flag;
        qsort(array, tmp, end - 1);
        qsort(array, end + 1, tmp1);
    }

    public static void main(String[] args) {
        int[] array = getRandomArray(30, 100);

        QSort qSort = new QSort();
        qSort.qsort(array);
        System.out.println(Arrays.toString(array));
    }
}
