package com.tiger.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tigerzhang on 16/8/18.
 */
public class ShuffleArray {
    public static class Solution {
        private int[] origin;

        public Solution(int[] nums) {
            origin = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return origin;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] ret = new int[origin.length];
            if(ret.length == 0){
                return ret;
            }

            Random random = new Random();
            ret[0] = origin[0];
            for(int i = 1; i < origin.length; i++){
                int replaceIdx = random.nextInt(i + 1);

                ret[i] = origin[i];
                int tmp = ret[replaceIdx];
                ret[replaceIdx] = origin[i];
                ret[i] = tmp;
            }

            return ret;
        }

        public static void main(String[] args) {
            Solution solution = new Solution(new int[]{1, 2, 3, 5});
            System.out.println(Arrays.toString(solution.shuffle()));
            System.out.println(Arrays.toString(solution.shuffle()));
            System.out.println(Arrays.toString(solution.shuffle()));
            System.out.println(Arrays.toString(solution.reset()));
        }
    }

}
