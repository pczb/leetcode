package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class ValidPalidrome {
    public class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) return false;
            int start = 0, end = s.length() - 1;
            while (start < end) {
                while (start < end && !isAlphet(s.charAt(start))) start++;
                while (start < end && !isAlphet(s.charAt(end))) end--;
                if (toLower(s.charAt(start)) != toLower(s.charAt(end))) return false;
                start++;
                end--;
            }
            return true;
        }

        public boolean isAlphet(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
        }

        public char toLower(char c) {
            if ('A' <= c && c <= 'Z') return (char) ('a' + (c - 'A'));
            return c;
        }
    }
}
