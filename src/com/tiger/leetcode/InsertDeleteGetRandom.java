package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by tigerzhang on 16/8/18.
 */
public class InsertDeleteGetRandom {


    public static class RandomizedSet {
        class Node{
            int val;
            int index;
        }

        Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
        ArrayList<Node> currentNodes = new ArrayList<Node>();
        Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            Node node = new Node();
            node.val = val;

            boolean ret = true;
            if(map.containsKey(val)){
                ret = false;
            }else {
                map.put(val, new LinkedList<Node>());
            }

            map.get(val).add(node);
            node.index = currentNodes.size();
            currentNodes.add(node);
            return ret;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            List<Node> list = map.get(val);
            if(list == null){
                return false;
            }
            Node node = list.remove(0);
            if(list.size() == 0){
                map.remove(val);
            }

            Node last = currentNodes.get(currentNodes.size() - 1);
            last.index = node.index;
            currentNodes.set(last.index, last);
            currentNodes.remove(currentNodes.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = random.nextInt(currentNodes.size());
            return currentNodes.get(idx).val;
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        assert randomizedSet.insert(1) == true;
        assert randomizedSet.insert(1) == false;
        assert randomizedSet.remove(1) == true;
        assert randomizedSet.remove(1) == false;
        randomizedSet.insert(1);
        assert randomizedSet.getRandom() == 1;
        for(int i = 0; i < 10; i++){
            randomizedSet.insert(i);
        }
        randomizedSet.remove(5);
        for(int i = 0; i < 10; i++){
            System.out.println(randomizedSet.getRandom());
        }

    }
}
