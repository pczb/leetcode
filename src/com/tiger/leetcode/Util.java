package com.tiger.leetcode;

import java.util.List;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class Util {
    public static <K> void printArray(K[] array) {
        for (K val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void printIntArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static <E> void printList(List<E> list){
        for(E e: list) System.out.print(e + " ");
        System.out.println();
    }
}
