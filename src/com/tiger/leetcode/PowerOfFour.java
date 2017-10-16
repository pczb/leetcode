package com.tiger.leetcode;

/**
 * Created by tigerzhang on 16/5/6.
 */
public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        int tmp = 1;
        int i = 0;
        while (tmp <= num && i <=32){
            if(tmp == num){
                return true;
            }
            tmp <<= 2;
            i += 2;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(5));
    }
}
