package com.tiger;

import java.util.Arrays;

/**
 * Created by tigerzhang on 16/8/11.
 */
public class Haha {
    public static void main(String[] args) {
        byte[] array = new byte[Integer.MAX_VALUE - 2];
        Arrays.fill(array, (byte)1);
        Arrays.binarySearch(array, (byte)2);
    }
}
