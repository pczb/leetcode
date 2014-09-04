package com.tiger.leetcode;

public class PermutationSequence {
    public String getPermutation(int n, int k) {  
        int[] nums = new int[n];
        int pCount = 1;  
        for(int i = 1 ; i <= n; ++i) {  
            nums[i - 1] = i;
            pCount *= i;
        }  
  
        k--;  
        String res = "";  
        for(int i = 0 ; i < n; i++) {  
            pCount = pCount/(n-i);  
            int selected = k / pCount;  
            res += nums[selected];
              
            for(int j = selected; j < n-i-1; j++)  
                nums[j] = nums[j+1];  
            k = k % pCount;  
        }  
        return res;  
    }  
    public static void main(String[] args){
        PermutationSequence solution = new PermutationSequence();
        System.out.println(solution.getPermutation(3, 5));
    }


}
