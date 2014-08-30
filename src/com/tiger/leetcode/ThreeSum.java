package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(num == null || num.length < 2) return ans;
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++) {
            if(i >= 1 && num[i] == num[i-1]) continue;
            for (int j = i + 1; j < num.length; j++) {
                if(j >= i+2 && num[j] == num[j-1]) continue;
                int sum = num[i] + num[j];
                if (sum > 0) break;
                int index = find(num, j + 1, num.length - 1, -sum);
                if (index != -1) {
                    ans.add(buildList(num[i], num[j], num[index]));
                }
            }
        }
       // printResult(ans);
        return ans;
    }


    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        sum.threeSum(new int[]{-1,-1,2,-3,4,3,0,1,2, -1, -4,4});
        sum.threeSum(new int[]{3,3,9});
    }
    private List<Integer> buildList(int a, int b, int c){
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(a);
        ret.add(b);
        ret.add(c);
        return ret;
    }
    public int find(int[] num, int start, int end,int key){
        if(start > end) return -1;
        int middle = start + (end - start >> 1);
        if(num[middle] == key) return middle;
        if(num[middle] > key) return find(num, start, middle - 1, key);
        return find(num, middle + 1, end, key);

    }


    private void printResult(List<List<Integer>> list) {
        for(List<Integer> innerList: list) {
            for (int val : innerList) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
