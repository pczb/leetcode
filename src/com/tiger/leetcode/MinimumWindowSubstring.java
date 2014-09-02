package com.tiger.leetcode;

import java.util.HashMap;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("", ""));
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String ret = "";
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch))
                map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }

        int flags = map.size();
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                int count = map.get(ch);
                if (count == 1) flags -= 1;
                map.put(ch, count - 1);
//                Util.printInts(ch, count - 1, flags);
            }
            if (flags == 0) {
                while (flags == 0 && j <= i) {
                    ch = s.charAt(j);
                    if (map.containsKey(ch)) {
                        int count = map.get(ch);
                        if (count == 0) flags += 1;
                        if (i - j + 1 < min) {
                            min = i - j + 1;
                            ret = s.substring(j, i + 1);
//                            System.out.println(ret);
                        }
                        map.put(ch, count + 1);
                    }
                    j++;
                }
            }
        }
        return ret;
    }
}
