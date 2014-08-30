package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by tigerzhang on 14/8/30.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int m = j + 1;
                int n = num.length - 1;
                while (m < n) {
                    int sum = num[i] + num[j] + num[m] + num[n];

                    if (sum > target) {
                        n--;
                    }
                    else if (sum < target) {
                        m++;
                    }
                    else if (sum == target) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[m]);
                        tmp.add(num[n]);

                        if (!hashSet.contains(tmp)) {
                            hashSet.add(tmp);
                            ans.add(tmp);
                        }

                        m++;
                        n--;
                    }
                }
            }
        }

        return ans;
    }

}
