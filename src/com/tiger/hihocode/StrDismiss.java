package com.tiger.hihocode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class StrDismiss {
    public static void main(String[] args) {
        System.out.println(findPalidromeLenght("AA".toCharArray(), 5));
    }

    private int processStr(String str){
        char[] stack = new char[str.length() + 1];
        stack[0] = 'D';
        int index = 0;
        char preChar;
        for(int i = 0; i < str.length() - 1;){
           if(str.charAt(i) == stack[index]){
               while(str.charAt(i) == stack[index]) i++;
               index--;
           }else{
               index++;
               stack[index] = str.charAt(i);
               i++;
           }
        }
        return findPalidromeLenght(stack, index);

    }

    private static int findPalidromeLenght(char[] array, int len){
        int start = 0;
        int maxStep = 0;
        int[] dp = new int[len];
        for(int i = 0; i < dp.length; i++) dp[i] = 1;
        for(int step = 1; step < len; step++){
            for(int i = step; i < len - step; i++){
                if(dp[i] == 1 && array[i - step] == array[i + step]){
                    dp[i] = 1;
                    maxStep = 2 + 2*step;
                }else{
                    dp[i] = 0;
                }
            }
        }
        return maxStep;
    }
}
