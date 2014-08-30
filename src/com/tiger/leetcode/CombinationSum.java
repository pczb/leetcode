package com.tiger.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tigerzhang on 14/8/31.
 */
public class CombinationSum {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null||candidates.length == 0) return null;
        Arrays.sort(candidates);
        result.clear();
        ArrayList<Integer> list = new ArrayList<Integer>();
        resolve(candidates,target,list,0);
        return result;
    }
    public void resolve(int[]a,int key, ArrayList<Integer> list,int i){
        if(key == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            result.add(temp);
            return;
        }
        if(i == a.length) return;
        resolve(a,key,list,i+1);
        int count = 1;
        while(a[i]*count <= key){
            for(int j = 1;j<=count;j++)
                list.add(a[i]);
            resolve(a,key-a[i]*count,list,i+1);
            for(int j = 1;j<=count;j++)
                list.remove(list.size()-1);
            count++;
        }
    }
}
