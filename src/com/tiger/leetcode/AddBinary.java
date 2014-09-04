package com.tiger.leetcode;

/**
 * Created by Administrator on 14-9-4.
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        int m = a.length()-1;
        int n = b.length()-1;
        int addition = 0;
        int temp;

        String sum = "";

        while(m>=0 || n>=0){
            if(m>=0 && n>=0)
                temp = (a.charAt(m)-'0') + (b.charAt(n)-'0') + addition;
            else if(m>=0)
                temp = (a.charAt(m)-'0') + addition;
            else
                temp = (b.charAt(n)-'0') + addition;

            if(temp>=2){
                addition = 1;
                temp = temp-2;
            }
            else{
                addition = 0;
            }
            sum = Integer.toString(temp)+sum;
            m--;
            n--;
        }

        if(addition==1)
            return "1"+sum;
        else
            return sum;

    }
}
