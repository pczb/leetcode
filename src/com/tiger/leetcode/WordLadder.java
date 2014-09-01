package com.tiger.leetcode;

import java.util.*;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
       // HashMap<String, List<String>> map = buildMap(dict);
        dict.add(end);
        return  bfs(start, end, dict);
    }

    public int bfs(String start, String end, Set<String> dict) {
        HashSet<String> visited = new HashSet<String>();

        HashSet<String> preLevel = new HashSet<String>();
        preLevel.add(start);
        int count = 0;

        while (!preLevel.isEmpty()) {
            count += 1;
            HashSet<String> nextLevel = new HashSet<String>();
            for(String str: preLevel) {
                visited.add(str);
                if(str.equals(end)) return count;
              //  System.out.println(map.get(str));

//                ArrayList<String> list = new ArrayList<String>();
                char[] array = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {
                    char oldChar = array[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldChar) continue;
                        array[i] = c;
                        String next = new String(array);
                        if(dict.contains(next) && !visited.contains(next)) nextLevel.add(next);
                    }
                    array[i] = oldChar;
                }
            }
            preLevel = nextLevel;
        }
        return -1;
    }

    public HashMap<String, List<String>> buildMap(Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : dict) {
            map.put(str, new ArrayList<String>());
            char[] array = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                char oldChar = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == oldChar) continue;
                    array[i] = c;
                    String next = new String(array);
                    if (dict.contains(next)) map.get(str).add(next);
                }
                array[i] = oldChar;
            }
          //  System.out.println(map.get(str).size());
        }
        return map;
    }

    public static void main(String[] args) {
        String start = "hit", end = "cog";
        String[] sts = new String[]{"hot","dot","dog","lot","log"};
        HashSet<String> dict = new HashSet<String>();
        for(String str: sts) dict.add(str);
    //    dict.add(start); dict.add(end);
        WordLadder ladder = new WordLadder();
        System.out.println(ladder.ladderLength(start, end, dict));
    }
}
