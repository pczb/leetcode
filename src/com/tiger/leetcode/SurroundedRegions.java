package com.tiger.leetcode;

import java.util.Scanner;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class SurroundedRegions {

    public static void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        int startX = 0, startY = 0, endX = m - 1, endY = n - 1;

        change(board, startX, startY, endX, endY);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private static void traverse(char[][] board, int x, int y) {
        if(board[x][y] == 'X' || board[x][y] == '#') return;
        board[x][y] = '#';
        if(x - 1 >= 0) traverse(board, x - 1, y);
        if(x + 1 < board.length) traverse(board, x + 1, y);
        if(y - 1 >= 0) traverse(board, x, y - 1);
        if(y + 1 < board[0].length) traverse(board, x, y + 1);
    }
    private static void change(char[][] board, int startX, int startY, int endX, int endY) {

        for (int i = startX; i <= endX; i++) {
            traverse(board, i, startY);
            traverse(board, i, endY);
        }

        for (int i = startY; i <= endY; i++) {
            traverse(board, startX, i);
            traverse(board, endX, i);
        }
    }

    private static void printBoard(char[][] board){
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readBoard(Scanner scanner) {
        String line = scanner.nextLine();
        int m = Integer.valueOf(line.split(" ")[0]), n = Integer.valueOf(line.split(" ")[1]);
        char[][] board = new char[m][n];
        for(int i = 0; i < m; i++){
            line = scanner.nextLine();
            for(int j = 0; j < n; j++)
                board[i][j] = line.charAt(2*j);

        }
        return board;
    }

    public static void main(String[] args) {
        String str = "5 4\n" +
                "X X X X\n" +
                "X O O X\n" +
                "X O O X\n" +
                "X X X X\n" +
                "X O X X\n" +
                "";
        char[][] board = readBoard(new Scanner(str));
        solve(board);
        printBoard(board);
    }
}
/*
4 4
X X X X
X O O X
X O O X
X X X X
*/