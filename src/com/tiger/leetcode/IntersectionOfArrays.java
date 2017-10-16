package com.tiger.leetcode;

import java.util.Arrays;

/**
 * Created by tigerzhang on 16/6/15.
 */
public class IntersectionOfArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int min = nums1.length + nums2.length;
        int[] ret = new int[min];
        int idx = 0;
        if(min == 0){
            return ret;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idxa = 0, idxb = 0;
        while (idxa < nums1.length && idxb < nums2.length){
            if(nums1[idxa] == nums2[idxb]){
                ret[idx++] = nums1[idxa];
                idxa++;
                idxb++;
            }else if(nums1[idxa] < nums2[idxb]){
                idxa++;
            }else{
                idxb++;
            }
        }

        int[] tmp = new int[idx];
        System.arraycopy(ret, 0, tmp, 0, idx);
        return tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 2, 1, 3};
        int[] b = new int[]{2, 2, 1};
        System.out.println(Arrays.toString(intersection(a, b)));
    }
}
