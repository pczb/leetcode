package com.tiger.leetcode;
public class EditDistance{
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= n; i++) 
            dp[0][i] = i;
        for(int i = 1; i <= m; i++) 
            dp[i][0] = i;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int tmp = m + n;
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    tmp = dp[i-1][j-1];
                else 
                    tmp = dp[i-1][j-1] + 1;
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                dp[i][j] = Math.min(dp[i][j], tmp);
            }
        }
        return dp[m][n];
    }   
    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        System.out.println(solution.minDistance("Ha", "Ha"));
        System.out.println(solution.minDistance("Ha", "Ca"));
        System.out.println(solution.minDistance("HaB", "HcB"));
        System.out.println(solution.minDistance("", "HcB"));
        System.out.println(solution.minDistance("", ""));
    }

}
