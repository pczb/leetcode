package com.tiger.leetcode;

/**
 * Created by tigerzhang on 14/9/2.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++){
                if(search(board,i,j,word,0)) return true;
            }
        return false;
    }
    private int m , n;
    private boolean search(char[][] board,int i,int j,String word,int index){
        if(word.charAt(index) != board[i][j]) return false;
        if(index == word.length()-1) return true;
        board[i][j] = '#';
        if(i-1 >= 0){
            if(search(board,i-1,j,word,index+1)) return true;
        }
        if(i+1 < m){
            if(search(board,i+1,j,word,index+1)) return true;
        }
        if(j-1 >= 0){
            if(search(board,i,j-1,word,index+1)) return true;
        }
        if(j+1 < n){
            if(search(board,i,j+1,word,index+1)) return true;
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
