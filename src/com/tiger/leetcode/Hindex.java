package com.tiger.leetcode;

import java.util.Arrays;

/**
 * Created by tigerzhang on 2017/3/3.
 */
public class Hindex {
    public static int hIndex(int[] citations) {

        Arrays.sort(citations);
        int start = 0;
        int end = citations.length - 1;
        int len = citations.length;
        if(len == 0){
            return 0;
        }
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(citations[middle] >= (len - middle)){
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }
        return len - end - 1;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1,2,2,2}));
        System.out.println(hIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(hIndex(new int[]{1}));
    }
}
