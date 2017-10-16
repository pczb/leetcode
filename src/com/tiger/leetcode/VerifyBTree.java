package com.tiger.leetcode;

import java.util.StringJoiner;

/**
 * Created by tigerzhang on 16/2/3.
 */
public class VerifyBTree {
    public boolean isValidSerialization(String preOrder) {
        String[] tmp = preOrder.split(",");
        return traverBtree(tmp, 0) == tmp.length;
    }
    public int traverBtree(String[] preOrder, int startPos){
        int len = preOrder.length;

        if(startPos >= len){
            return -1;
        }

        if(preOrder[startPos].equals("#")){
            return 1;
        }

        int passLength = 1;
        int a = traverBtree(preOrder, startPos + passLength);
        if(a == -1){
            return -1;
        }
        passLength += a;

        a = traverBtree(preOrder, startPos + passLength);
        if(a == -1){
            return -1;
        }
        passLength += a;
        return passLength;
    }

    public static void main(String[] args) {
        VerifyBTree verifyBTree = new VerifyBTree();
        System.out.println(verifyBTree.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(verifyBTree.isValidSerialization("9,#,#,1"));
    }
}
