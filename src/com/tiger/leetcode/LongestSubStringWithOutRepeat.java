package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 * problem definition:
 * Given a string, findClosest the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubStringWithOutRepeat {
    public static void main(String[] args) {
        LongestSubStringWithOutRepeat solution = new LongestSubStringWithOutRepeat();
        System.out.println(solution.lengthOfLongestSubstring("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac"));
        System.out.println(solution.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] indexRecord = new int[256];
        for (int i = 0; i < indexRecord.length; i++)
            indexRecord[i] = -1;

        char[] chars = s.toCharArray();
        int maxLen = -1;
        int preLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i];
            if (indexRecord[index] != -1) {
                preLen = Math.min(preLen + 1, i - indexRecord[index]);
                maxLen = Math.max(preLen, maxLen);
            } else {
                preLen += 1;
                maxLen = Math.max(preLen, maxLen);

            }
            indexRecord[index] = i;
        }
        return maxLen;
    }
}
