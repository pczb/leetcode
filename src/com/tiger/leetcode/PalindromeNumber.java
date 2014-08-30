package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;

        boolean flag = true;
        int len = 1;
        int tmp = x;
        while(tmp/10 != 0){
            tmp = tmp / 10;
            len *= 10;
        }

        while(x > 0) {
            int left = x % 10;
            int right = x / len;
            if(left != right){
                flag = false;
                break;
            }
            x = x - right * len;
            x = x/10;
            len = len / 100;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
    }
}
