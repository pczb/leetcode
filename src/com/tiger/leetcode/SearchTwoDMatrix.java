package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class SearchTwoDMatrix {
    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        System.out.println(searchMatrix(martix, 50));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;

        int middle = 0;
        int start = 0, end = m - 1;
        while (start <= end) {
            middle = (start + end) / 2;
            if (matrix[middle][0] == target) return true;
            if (matrix[middle][0] >= target) end = middle - 1;
            else start = middle + 1;
        }

        int row = end;
        start = 0;
        end = n - 1;
        while (start <= end) {
            middle = (start + end) / 2;
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] > target) end = middle - 1;
            else start = middle + 1;
        }
        return false;
    }
}
