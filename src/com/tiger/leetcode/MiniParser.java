package com.tiger.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tigerzhang on 16/8/19.
 * Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.
 */

public class MiniParser {

    public NestedInteger deserialize(String s) {
        Context context = new Context();
        NestedInteger nestedInteger =
        context.stack.push(new NestedInteger());
        doParse(s, context);
        return context.stack.peek().getList().get(0);
    }

    class Context{
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        private int consumeLen = -1;
    }

    public void parseSingleInteger(String s, Context context){

        int val = 0;
        int flag = 1;

        int idx = context.consumeLen += 1;
        if(s.charAt(idx) == '-'){
            flag = -1;
            idx++;
        }

        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9'){
            val =  val * 10 + (s.charAt(idx) - '0');
            idx += 1;
        }

        context.consumeLen = idx - 1;
        NestedInteger nestedInteger = new NestedInteger();
        nestedInteger.setInteger(flag * val);
        context.stack.peek().add(nestedInteger);
    }

    private void doParse(String s, Context context){
        while (context.consumeLen < s.length() - 1) {
            char nextChar = s.charAt(context.consumeLen + 1);

            if (nextChar == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                context.stack.peek().add(nestedInteger);
                context.consumeLen += 1;
                context.stack.push(nestedInteger);
            } else if (nextChar == ']') {
                context.stack.pop();
                context.consumeLen += 1;
            } else if (nextChar == ',') {
                context.consumeLen += 1;
            } else {
                parseSingleInteger(s, context);
            }
        }
    }

    public static void main(String[] args) {
       MiniParser parser = new MiniParser();
        NestedInteger nestedInteger = parser.deserialize("[123,456,[789],[789]");
        NestedIterator nestedIterator = new NestedIterator(Arrays.asList(nestedInteger));
        while (nestedIterator.hasNext()){
            System.out.println(nestedIterator.next());
        }
    }
}
