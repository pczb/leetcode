package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack[++index] = s.charAt(i);
            else if(index >=0 && s.charAt(i) - stack[index] >= 1 && s.charAt(i) - stack[index] <= 2) index--;
            else return false;
        }
        if(index == -1) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("("));
    }
}
