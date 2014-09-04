package com.tiger.leetcode;
class Sqrt {
    public int sqrt(int x) {
        if (x ==0)  
            return 0;  
        double pre;  
        double cur = 1;  
        do  
        {  
            pre = cur;  
            cur = x / (2 * pre) + pre / 2.0;  
        } while (Math.abs(cur - pre) > 0.00001);  
        return (int)cur; 
    }
    public static void main(String[] args){
        Sqrt sloution = new Sqrt();
        System.out.println(sloution.sqrt(0));
        System.out.println(sloution.sqrt(1));
        System.out.println(sloution.sqrt(4));
        System.out.println(sloution.sqrt(9));
        System.out.println(sloution.sqrt(2131123));
        System.out.println(sloution.sqrt(2147395599));
    }

}
