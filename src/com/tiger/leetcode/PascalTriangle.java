package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class PascalTriangle {
    public static List<Integer> generate(int numRows) {
        numRows += 1;
        List<Integer> pre = new ArrayList<Integer>();
        if(numRows <= 0) return pre;
        pre.add(1);
        for (int i = 2; i <= numRows; i++) {
            int tmp = 1;
            int tmp2 = 0;
            pre.add(1);
            for (int j = 1; j <= i -  2; j++) {
                tmp2 = pre.get(j);
                pre.set(j, tmp + pre.get(j));
                tmp = tmp2;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        List<Integer> list = generate(3);
        Util.printList(list);

    }
}
