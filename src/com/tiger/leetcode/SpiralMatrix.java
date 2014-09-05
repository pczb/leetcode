package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return ans;

        int xStart = 0;
        int yStart = 0;
        int xEnd = matrix[0].length - 1;
        int yEnd = matrix.length - 1;

        ans.add(matrix[0][0]);

        int i = 0, j = 0;
        while (true) {
            while (i < xEnd) ans.add(matrix[j][++i]);
            if (++yStart > yEnd) break;

            while (j < yEnd) ans.add(matrix[++j][i]);
            if (xStart > --xEnd) break;

            while (i > xStart) ans.add(matrix[j][--i]);
            if (yStart > --yEnd) break;

            while (j > yStart) ans.add(matrix[--j][i]);
            if (++xStart > xEnd) break;
        }
        return ans;
    }
}
