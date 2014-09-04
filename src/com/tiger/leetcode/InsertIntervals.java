package com.tiger.leetcode;

import java.util.*;

/**
 * Created by tigerzhang on 14/9/5.
 */
public class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> ans = new ArrayList<Interval>();
        int i = 0;
        int len = intervals.size();
        while (i < len && intervals.get(i).end < newInterval.start) {
            ans.add(intervals.get(i));
            i++;
        }

        while (i < len && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        ans.add(newInterval);
        while (i < len) {
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }


    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> ans = new LinkedList<Interval>();
        if (intervals.size() == 0) return ans;
        ans.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int size = ans.size();
            if (ans.get(size - 1).start <= intervals.get(i).start && intervals.get(i).start <= ans.get(size - 1).end)
                ans.get(size - 1).end = Math.max(ans.get(size - 1).end, intervals.get(i).end);
            else
                ans.add(intervals.get(i));
        }
        return ans;
    }

}

class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}