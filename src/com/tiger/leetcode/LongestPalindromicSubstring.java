package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int dp[][] = new int[2][s.length()];
        int start = 0, end = 0;

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[1][i] = 1;
                start = i;
                end = i + 1;
            }
            dp[0][i] = 1;
        }
        dp[0][s.length() - 1] = 1;
        int m = s.length() / 2;
        int len = s.length();

        for(int i = 1; i <= m; i++){

            for(int j = i; j < len - i; j++){
               if(dp[0][j] == 1 && s.charAt(j - i) == s.charAt(j + i)) {
                   start = j - i;
                   end = j + i;
               }else{
                   dp[0][j] = 0;
               }
            }

            for(int j = i; j < len - i - 1; j++){
                if(dp[1][j] == 1 && s.charAt(j - i) == s.charAt(j + i + 1)) {
                    start = j - i;
                    end = j + i + 1;
                }else{
                    dp[1][j] = 0;
                }
            }
        }
//        System.out.println(start+" "+ end);
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    }
}
