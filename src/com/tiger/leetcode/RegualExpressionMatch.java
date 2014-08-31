package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class RegualExpressionMatch {
    public static void main(String[] args) {
        System.out.println(match("ab", "a.*"));
        System.out.println(match("aab", "c*a*b"));
        System.out.println(match("a", "ab*"));
        System.out.println(match("ab", "a.*c*b"));
        System.out.println(match("", ""));
    }

    public static boolean match(String query, String pattern) {
        return match(query.toCharArray(), pattern.toCharArray(), 0, 0);
    }

    private static boolean match(char[] query, char[] pattern, int i, int j) {
        if (i == query.length && j == pattern.length) return true; //如果query和pattern都匹配结束，则返回成功
        if (i <= query.length && j < pattern.length) { //i <= query.length 主要是为了防止pattern最后一个字符串为.*的情况下的匹配
            if (j < pattern.length - 1) {
                if (pattern[j + 1] == '*') {
                    if (i == query.length) return match(query, pattern, i, j + 2);
                    if (pattern[j] == '.' || query[i] == pattern[j]) {
                        if (match(query, pattern, i + 1, j)) return true;
                    }
                    if (match(query, pattern, i, j + 2)) return true;
                } else {
                    if (i == query.length) return false;
                    if (pattern[j] == '.' || pattern[j] == query[i]) return match(query, pattern, i + 1, j + 1);
                }
            } else {
                if (i == query.length) return false;
                if (pattern[j] == '.' || pattern[j] == query[i]) return match(query, pattern, i + 1, j + 1);
            }
        }
        return false;
    }
}
