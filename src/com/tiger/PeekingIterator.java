package com.tiger;

/**
 * Created by tigerzhang on 16/3/14.
 */
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Integer;
import java.lang.System;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> backend;
    private Integer top;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.backend = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(top == null && backend.hasNext()){
            top = backend.next();
        }
        return top;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = null;
        if(top != null){
            ret = top;
            top = null;
        }else{
            ret = backend.next();
        }
        return ret;
    }

    public boolean hasNext() {
        return top != null || backend.hasNext();
    }

    public static void main(String[] args){
        PeekingIterator iterator = new PeekingIterator(Arrays.asList(1, 2 ,3).iterator());
        System.out.println(iterator.peek());
        System.out.println(iterator.peek());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.peek());
        System.out.println(iterator.peek());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
    }
}
