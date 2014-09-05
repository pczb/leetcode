package com.tiger.leetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
        if(A == null) return false;
        int len = A.length;
        int maxLen = 0;

        for(int i = 0; i < len; i++){
            if(maxLen < i)
                break;
            if(i + A[i] > maxLen)
                maxLen = i + A[i];
 //           System.out.println(maxLen);
        }
        return maxLen >= len - 1 ? true : false;
    }
    
    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] array = {2,3,1,1,4};
        int[] array1 = {3,2,1,0,4};
        System.out.println(solution.canJump(array));
    }
}
            

