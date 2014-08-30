package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class ReverseWord {
    public class Solution {
        public String reverseWords(String s){
            int i,j;
            for(i = 0;i<s.length();i++){
                if(s.charAt(i) != ' ') break;
            }
            for(j=s.length()-1;j>=0;j--){
                if(s.charAt(j) != ' ') break;
            }
            if(i > j) return "";
            s = s.substring(i, j + 1);
            char[] array = s.toCharArray();
            reverse(array,0,array.length-1);
            int start,end;
            for( start=0, end =0;end<array.length;end++){
                if(array[end] == ' '){
                    reverse(array,start,end-1);
                    start = end+1;
                }
            }
            reverse(array,start,end-1);
            for(i=0,j=0;i<array.length;){
                if(array[i] == ' ' && array[i+1] == ' '){
                    i++;
                }else{
                    array[j] = array[i];
                    i++;
                    j++;
                }
            }
            return new String(array,0,j);
        }
        private void reverse(char[] array,int start,int end){
            while(start < end){
                char tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
