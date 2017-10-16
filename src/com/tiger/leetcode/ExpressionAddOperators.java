package com.tiger.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * Created by tigerzhang on 16/5/6.
 */
public class ExpressionAddOperators {
    int target;
    List<String> result;

    public List<String> addOperators(String num, int target) {
        return null;
    }

    private int calcResult(Stack<Integer> nums, Op operators){
        switch (operators){
            case TIMES:
                nums.push(nums.pop() * nums.pop());
            case PLUS:
                nums.push(nums.pop() + nums.pop());
            case MINUS:
                nums.push(nums.pop() - nums.pop());
        }
        return 0;
    }

    public void solve(String number, int idx, Stack<Integer> nums, StringBuilder sb){
        if(idx == number.length()){

        }

        // +
        int currentNum = Integer.valueOf(number.charAt(idx));
//        sb.append("+" + currentNum);
//        solve(number, idx + 1, calcReulst(prevSum, prevNum, prevOp), currentNum, 1, sb);
//        sb.setCharAt(sb.length() -  2, '-');
//        solve(number, idx + 1, calcReulst(prevSum, prevNum, prevOp), currentNum, 2, sb);
//        sb.setCharAt(sb.length() - 2, '*');
//        solve(number, idx + 1, prevSum, currentNum, 3, sb);
    }

    private enum  Op {
        PLUS, MINUS, TIMES;
    }

    private boolean isVowel(char c){
        c = Character.toLowerCase(c);
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c;
    }
    public String reverseVowels(String s) {
        if(s == null){
            return s;
        }

        int start = 0, end = s.length() - 1;
        char[] result = new char[s.length()];
        while(start <= end){

            while(start <= end) {
                result[start] = s.charAt(start);
                if(isVowel(s.charAt(start))){
                    break;
                }
                start++;
            }

            while(end >= start) {
                result[end] = s.charAt(end);
                if(isVowel(s.charAt(end))){
                    break;
                }
                end--;
            }

            if(start < end){
                char tmp = s.charAt(start);
                result[start] = result[end];
                result[end] = tmp;
            }

            start++;
            end--;
        }
        return new String(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix[0].length;
        int j = 0;
        while (i >= 0 && j < matrix.length){
            if(matrix[j][i] == target){
                return true;
            }
            if(matrix[j][i] < target){
                j += 1;
            }else {
                i -= 1;
            }
        }
        return false;
    }

    public String reverse(String s){
        char[] result = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i <= j){
            char tmp = s.charAt(i);
            result[i] = s.charAt(j);
            result[j] = tmp;
            i++;
            j--;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        System.out.println("a" + expressionAddOperators.reverseVowels(" ") + "B ");
        System.out.println(expressionAddOperators.reverse("asedf"));
    }
}
