package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class StockThree {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 10,11,3,20,38,40,11,39}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] leftMax = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                leftMax[i] = leftMax[i - 1];
                min = prices[i];
            } else leftMax[i] = Math.max(leftMax[i - 1], prices[i] - min);
        }
        int maxProfit = 0;
        int max = prices[prices.length - 1];
        int rightProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            if (rightProfit < max - prices[i]) rightProfit = max - prices[i];
            if (rightProfit + leftMax[i] > maxProfit) maxProfit = rightProfit + leftMax[i];

        }
        return maxProfit;
    }
}
