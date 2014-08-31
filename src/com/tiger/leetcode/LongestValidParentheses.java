package com.tiger.leetcode;

import java.util.Stack;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int left = 0;
        int max = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
                left += 1;
            } else if (s.charAt(i) == ')' && left > 0) {
                int current = 0;
                while (stack.peek() != -1) current += stack.pop();
                stack.pop();
                current += 2;
                while (!stack.empty() && stack.peek() != -1) current += stack.pop();
                stack.push(current);
                if (current > max) max = current;
                left -= 1;

            } else {
                int current = 0;
                while (!stack.empty()) current += stack.pop();
                if (current > max) max = current;
                left = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(((((((((()"));
    }
}
