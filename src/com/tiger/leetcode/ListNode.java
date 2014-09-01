package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }


}

class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int label){
        this.label = label;
    }
}
