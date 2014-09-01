package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        int max = 0;
        for(int no: num) {
            if(set.contains(no)) continue;
            set.add(no);
            if(!map.containsKey(no + 1) && !map.containsKey(no - 1)) {
                map.put(no, no);
                max = Math.max(max, 1);
            }
            if(map.containsKey(no + 1) && !map.containsKey(no - 1)) {
                int next = map.get(no + 1);
                map.remove(no + 1);
                if(next != no + 1)
                    map.remove(next);
                map.put(no, next);
                map.put(next, no);
                max = Math.max(Math.abs(next - no) + 1, max);
                    System.out.println(no + " " + next);
            }
            if(map.containsKey(no - 1) && !map.containsKey(no + 1)) {
                int next = map.get(no - 1);
                map.remove(no - 1);
                if(next != no - 1)
                map.remove(next);
                map.put(no, next);
                map.put(next, no);
                  System.out.println(no + " " + next);
                max = Math.max(Math.abs(next - no) + 1, max);
            }

            if(map.containsKey(no - 1) && map.containsKey(no + 1)) {
                int next = map.get(no - 1);
                int next2 = map.get(no + 1);
                map.remove(no - 1);
                map.remove(no + 1);
                map.remove(next);
                map.remove(next2);
                map.put(next, next2);
                map.put(next2, next);
                System.out.println(next + " " + next2);
                max = Math.max(Math.abs(next - next2) + 1, max);

            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{ 7,-2,9,9,1,9,8,-4,6,-6,-6,4,1,3,6,3,5,-2,3,4,-6,1,5,-9,6,1,2,-2,1}));
    }
}
