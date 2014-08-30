package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null) return 0;
        int area = 0;
        int i = 0, j = height.length - 1;
        while (i < j)
        {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if(height[i] > height[j]) j--;
            else i++;
        }
        return area;
    }
}
