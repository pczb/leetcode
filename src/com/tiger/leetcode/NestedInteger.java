package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/*
 * Created by tigerzhang on 16/5/7.
 */

public class NestedInteger {
     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     private Integer val;
     private List<NestedInteger> list = new ArrayList<NestedInteger>();

     public boolean isInteger(){
        return val != null;
     }

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger(){
        return val;
     }

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value){
        this.val = value;
     }

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni){
        this.list.add(ni);
     }

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList(){
        return isInteger()? null: list;
     }
}

class NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> iteratorStack;
    private Integer nextVal;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.iteratorStack = new Stack<Iterator<NestedInteger>>();
        this.iteratorStack.push(nestedList.iterator());
    }

    public Integer next() {
        return nextVal;
    }

    public boolean hasNext() {
        while (!iteratorStack.empty()){
            Iterator<NestedInteger> iterator = iteratorStack.peek();
            if(iterator.hasNext()){
                NestedInteger node = iterator.next();
                if(node.isInteger()){
                    nextVal = node.getInteger();
                    return true;
                }else {
                    iteratorStack.push(node.getList().iterator());
                }
            }else {
                iteratorStack.pop();
            }
        }
        return false;
    }
}
