package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(4);
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        dfs(ans, n * 2, 0, 0, new char[n * 2]);
       // for(String str: ans) System.out.println(str);
        return ans;
    }

    private void dfs(List<String> ans, int n, int left, int index, char[] buffer) {
        if(n == 0) {
            ans.add(new String(buffer));
            return;
        }
        if(left == n) {
            for(int i = 0; i < n; i++){
                buffer[index] = ')';
                index++;
            }
            dfs(ans, 0, 0, index, buffer);
        }
        else if(left == 0) {
            buffer[index] = '(';
            dfs(ans, n - 1, left + 1, index + 1, buffer);
        }
        else{
            buffer[index] = ')';
            dfs(ans, n - 1, left - 1, index + 1, buffer);
            buffer[index] = '(';
            dfs(ans, n - 1, left + 1, index + 1, buffer);
        }
    }
}
