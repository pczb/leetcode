package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class StockOne {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) min = price;
            else {
                if (price - min > maxProfit) maxProfit = price - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,10,1,4,5,6,7,8,8,0,7}));
    }
}
