package com.tiger.leetcode;

import java.util.Set;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class WordBreak {
    public  boolean wordBreak(String s, Set<String> dict) {
        int[] dp = new int[s.length()];
        return dfs(s, dict, dp, 0);
    }

    public  boolean dfs(String s, Set<String> dict, int[] dp, int i){
        if(i == s.length()) return true;
        if(dp[i] == 1) return true;
        else if(dp[i] == -1) return false;
        else{
            for(int j = i; j < s.length(); j++){
                if(dict.contains(s.substring(i, j + 1))){
                    if(dfs(s, dict, dp, j + 1)){
                        dp[i] = 1;
                        //                System.out.println(s.substring(i, j + 1));
                        return true;
                    }
                }
            }
            dp[i] = -1;
        }
        return false;
    }
}
