package com.tiger.leetcode;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiConsumer;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class CombinationSum {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        result.clear();
        ArrayList<Integer> list = new ArrayList<Integer>();
        resolve(candidates, target, list, 0);
        return result;
    }

    public void resolve(int[] a, int key, ArrayList<Integer> list, int i) {
        if (key == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            result.add(temp);
            return;
        }
        if (i == a.length) return;
        resolve(a, key, list, i + 1);
        int count = 1;
        while (a[i] * count <= key) {
            for (int j = 1; j <= count; j++)
                list.add(a[i]);
            resolve(a, key - a[i] * count, list, i + 1);
            for (int j = 1; j <= count; j++)
                list.remove(list.size() - 1);
            count++;
        }
    }

    public static class Solution {
        public static int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);

            return solve(nums, target, nums.length - 1, new LinkedList<Integer>());
        }

        public static int solve(int nums[], int target, int idx, LinkedList<Integer> current){
            if(target == 0){
                System.out.println(Joiner.on(",").join(current));
                return 1;
            }

            if(idx < 0 || target < nums[0]){
                return 0;
            }

            current.add(nums[idx]);
            int result = solve(nums, target - nums[idx], idx, current);
            current.pop();

            result += solve(nums, target, idx - 1, current);
            return result;
        }

        private static int binaryFind(int[] array, int target){
            int end = array.length - 1;
            int start = 0;
            while (start <= end){
                int middle = (start + end) / 2;
                if(array[middle] == target){
                    return middle;
                }else if(array[middle] > target){
                    end = middle - 1;
                }else {
                    start = middle + 1;
                }
            }
            return end;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
//        System.out.println(a[Solution.binaryFind(a, 0)]);
        System.out.println(Solution.combinationSum4(a, 4));
    }
}
