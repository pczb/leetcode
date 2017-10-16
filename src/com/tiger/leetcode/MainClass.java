package com.tiger.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tigerzhang on 2017/8/29.
 */


public class MainClass {
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            List<Integer> prev = new LinkedList<>();
            return dp(nums, 0, prev);
        }

        public List<Integer> dp(int[] nums, int index, List<Integer> prev) {
            if (index >= nums.length) {
                return prev;
            }

            boolean canAdd = true;
            for (int a: prev) {
                if (nums[index] % a != 0) {
                    canAdd = false;
                    break;
                }
            }

            List<Integer> with = new ArrayList<>(prev);
            if (canAdd) {
                with.add(nums[index]);
                with = dp(nums, index + 1, with);
            }

            List<Integer> withOut = new ArrayList<>(prev);
            withOut = dp(nums, index + 1, withOut);

            if (with.size() >= withOut.size()) {
                return with;
            }
            return withOut;
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new Solution().largestDivisibleSubset(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
