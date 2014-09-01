package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class StockII {
    public class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length <= 1) return 0;
            int start = prices[0];
            int profit  = 0;
            int i;
            for(i = 1; i < prices.length;i++){
                if(prices[i] < prices[i-1]){
                    profit += prices[i-1]-start;
                    start = prices[i];
                }
            }
            profit += prices[i-1]-start;
            return profit;

        }
    }
}
