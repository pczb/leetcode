package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();
        System.out.println(solution.atoi("-10.0"));
    }

    public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        int flag = 1;
        long res = 0;
        while (chars[i] == ' ') i++;
        if (chars[i] == '-') {
            flag = -1;
            i++;
        } else if (chars[i] == '+') {
            i++;
        }
        while (i < chars.length && isDigit(chars[i])) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = res * 10 + str.charAt(i) - '0';
            }
            if (res > Integer.MAX_VALUE) break;
            i++;
        }
        res = flag * res;
        if (res > 0 && res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        if (res < 0 && res < Integer.MIN_VALUE) res = Integer.MIN_VALUE;
        return (int) res;
    }

    private boolean isDigit(char i) {
        return (i >= '0' && i <= '9');
    }
}
