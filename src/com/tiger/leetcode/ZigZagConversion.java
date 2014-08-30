package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(s == null || s.length()==0 || nRows <=0)
            return "";
        if(nRows == 1)
            return s;
        StringBuffer buffer = new StringBuffer();
        int row = 1;
        int step = (nRows * 2) - 2;
        while(row <= nRows){
           for(int i = row; i <= s.length();){
               buffer.append(s.charAt(i-1));
               int middle = i + (nRows - row) * 2;
               if(middle > i && middle < i + step && middle <= s.length()) buffer.append(s.charAt(middle - 1));
               i += step;
           }
           row++;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        System.out.println(conversion.convert("ABCD", 3));
    }
}
