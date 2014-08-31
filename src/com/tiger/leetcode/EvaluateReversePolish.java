package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class EvaluateReversePolish {
    public class Solution {


        public int evalRPN(String[] tokens) {
            if(tokens == null || tokens.length == 0)
                return 0;
            int[] stack = new int[tokens.length];
            int index = -1;
            for(int i = 0; i < tokens.length; i++){
                if(isOperator(tokens[i])){
                    if(index < 1) return 0;
                    int op1 = stack[index-1];
                    int op2 = stack[index];
                    index -= 1;
                    stack[index] = eval(op1, op2, tokens[i]);
                }
                else{
                    try{
                        index++;
                        stack[index] = Integer.valueOf(tokens[i]);
                    }catch(Exception e){
                        return 0;
                    }
                }

            }
            return stack[0];
        }
        private boolean isOperator(String token){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
                return true;
            return false;
        }
        public int eval(int op1, int op2, String operator){
            if(operator.equals("+")) return op1 + op2;
            else if(operator.equals("-")) return op1 - op2;
            else if(operator.equals("*")) return op1 * op2;
            else if(operator.equals("/") && op2 != 0) return op1 / op2;
            return 0;

        }


    }
}
