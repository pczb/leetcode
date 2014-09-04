package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/5.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int lastLen = 0;
        int ret = 0;
        for(int i = 0; i <= s.length(); i++) {
            if(i == s.length() || s.charAt(i) == ' '){
                if(lastLen != 0)
                    ret = lastLen;

                lastLen = 0;
            }
            else lastLen++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LengthofLastWord solution = new LengthofLastWord();
        System.out.println(solution.lengthOfLastWord(""));
    }
}
