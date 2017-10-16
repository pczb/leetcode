package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
  Created by tigerzhang on 16/6/3.
 */
public class SummaryRanges {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }


    /** Initialize your data structure here. */
    class WrappedInterval{
        WrappedInterval prev;
        WrappedInterval next;
        Interval interval;
    }
    TreeMap<Integer, WrappedInterval> startMap;

    WrappedInterval head = new WrappedInterval();

    public SummaryRanges() {
        startMap = new TreeMap<Integer, WrappedInterval>();
    }

    public void addNum(int val) {
        Integer ceilKey = startMap.ceilingKey(val);
        Integer floorKey = startMap.floorKey(val);
//
//        WrappedInterval current = new WrappedInterval(Interval(val, val);
//        if(floorKey != null && floorKey == val -1){
//            current = startMap.get(floorKey).interval;
//            current.end = val;
//        }
//
//        if(ceilKey != null && current.end == ceilKey - 1){
//            current.end = startMap.get(ceilKey).interval.end;
//            startMap.remove(ceilKey);
//        }
//
//        startMap.put(current.start, current);

    }

//    public List<Interval> getIntervals() {
//        return new ArrayList<Interval>(startMap.values());
//    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 7, 2, 6};
        SummaryRanges summaryRanges = new SummaryRanges();
        for(int i: input){
            summaryRanges.addNum(i);
//            Util.printList(summaryRanges.getIntervals());
        }
    }
}

