package com.tiger.leetcode;

import java.util.*;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class WordLadderTwo {
    public static void main(String[] args) {
        WordLadderTwo ladderTwo = new WordLadderTwo();
        String start = "hit", end = "cog";
        String[] sts = new String[]{"hot","dot","dog","lot","log"};
        HashSet<String> dict = new HashSet<String>();
        for (String str : sts) dict.add(str);
        for (List<String> list : ladderTwo.findLadders(start, end, dict)) {
            ladderTwo.printPath(list);
        }
    }
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ans = new ArrayList<List<String>>();

        for(String str: dict) map.put(str, new ArrayList<String>());
        map.put(start, new ArrayList<String>());
        map.put(end, new ArrayList<String>());
        if (start == null || end == null) return ans;
        bfs(start, end, dict, ans);
        return ans;
    }

    public void bfs(String start, String end, Set<String> dict, List<List<String>> ans) {
    //    HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        boolean flag = false;
        List<String> currentLevel = new LinkedList<String>();
        while (!queue.isEmpty() && !flag) {
            int level = queue.size();

            currentLevel.clear();
            for (int i = 0; i < level; i++) {
                String top = queue.poll();
                if (dict.contains(top)) dict.remove(top);
                currentLevel.add(top);
            }

            List<String> nextLevel = new LinkedList<String>();

            for (String preString: currentLevel) {
                if (preString.equals(end)) {
                    flag = true;
                }
                if (flag) break;

                for (int i = 0; i < preString.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] array = preString.toCharArray();
                        if (c == preString.charAt(i)) continue;
                        array[i] = c;
                        String next = new String(array);
                        if (next.equals(end) || dict.contains(next)) {
                            map.get(next).add(preString);
                            queue.offer(next);
                        }
                    }
                }
            }
            if(queue.contains(end)) break;
        }
        ArrayList<String> list = new ArrayList<String>();
        list.add(end);
        buildPath(start, end, list, ans);
    }

    private void buildPath(String start, String end, List<String> list, List<List<String>> ans) {

        List<String> pre = map.get(end);


        if (end.equals(start)) {
            ArrayList<String> path = new ArrayList<String>(list);
            Collections.reverse(path);
            ans.add(path);
            return;
        }
        for (String s: pre){
            list.add(s);
            buildPath(start, s, list, ans);
            list.remove(list.size() - 1);
        }
    }

    private void printPath(List<String> path) {
        if (path == null) return;
        for (String str : path) System.out.print(str + "-->");
        System.out.println();
    }
}
