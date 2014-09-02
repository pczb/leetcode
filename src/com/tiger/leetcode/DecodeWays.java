package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        String str = "312312312312876898797";
        System.out.println(solution.numDecodings(str));
        System.out.println(solution.baseLine(str));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        char[] array = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (array[i] == '0') {
                if (array[i - 1] == '1' || array[i - 1] == '2')
                    dp[i + 1] = dp[i - 1];
                else
                    return 0;
            } else if (array[i - 1] == '0' || array[i - 1] >= '3')
                dp[i + 1] = dp[i];
            else if (array[i - 1] == '1' || array[i] <= '6')
                dp[i + 1] = dp[i] + dp[i - 1];
            else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }

    public int baseLine(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (isValid(s.substring(0, 1))) dp[1] = 1;
        else dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (isValid(s.substring(i - 1, i)))
                dp[i] = dp[i - 1];
            if (isValid(s.substring(i - 2, i)))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int code = Integer.parseInt(s);
        return code >= 1 && code <= 26;
    }
}
