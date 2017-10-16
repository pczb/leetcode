package com.tiger.lintcode;

import com.google.common.base.Joiner;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tigerzhang on 2017/1/4.
 */
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        // write your code here
        if(n < k || k < 0){
            throw new RuntimeException("aaa");
        }
        List<List<Integer>> ret = new LinkedList<>();

        for(int i = 1; i <= n - k + 1; i++){
            LinkedList<Integer> pre = new LinkedList<>();
            for(int tmp = 0; tmp < k; tmp++){
                pre.add(tmp + i);
            }
            ret.add(new LinkedList(pre));

            for(int j = i + k; j <= n; j++){
                pre.removeLast();
                pre.addLast(j);
                ret.add(new LinkedList(pre));
            }
            if(k == 1){
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Joiner.on(",").join(combine(13, 3)));

    }

}
