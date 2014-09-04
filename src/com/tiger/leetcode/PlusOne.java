package com.tiger.leetcode;

/**
 * Created by Administrator on 14-9-4.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len == 0) return digits;
        int additon = 1;
        int[] ret = digits;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] + additon >= 10){
                digits[i] = digits[i] + additon - 10;
            }else{
                digits[i] = digits[i] + additon;
                additon = 0;
            }
        }
        if(additon == 1) {
            ret = new int[len + 1];
            ret[0] = 1;
            for(int i = 0; i < digits.length; i++) ret[i+ 1] = digits[i];

        }
        return ret;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        for(int i: solution.plusOne(new int[]{9, 9}))
            System.out.print(i + " ");
    }
}
