package com.tiger.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tigerzhang on 14/9/1.
 */
public class SurroundedRegions {

    private static void printBoard(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readBoard(Scanner scanner) {
        String line = scanner.nextLine();
        String[] data = line.split(",");
        int m = data.length, n = data[0].length();
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = data[i].charAt(j);
        }
        return board;
    }

    public static void main(String[] args) {
        String str = "XOXOXO,OXOXOX,XOXOXO,OXOXOX";
        char[][] board = readBoard(new Scanner(str));
        printBoard(board);
        System.out.println();
        new SurroundedRegions().solve(board);
        printBoard(board);
    }

    //this version will cause stack exception
    /*private static void traverse(char[][] board, int x, int y) {
        if (board[x][y] == 'X' || board[x][y] == '#') return;
        board[x][y] = '#';
        HashSet<Point> visited = new HashSet<Point>();
        if (x - 1 >= 0) traverse(board, x - 1, y);
        if (x + 1 < board.length) traverse(board, x + 1, y);
        if (y - 1 >= 0) traverse(board, x, y - 1);
        if (y + 1 < board[0].length) traverse(board, x, y + 1);
    }*/

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        int startX = 0, startY = 0, endX = m - 1, endY = n - 1;

        change(board);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void traverse(char[][] board, int x, int y) {
        HashSet<Point> visited = new HashSet<Point>();
        Stack<Point> toTravel = new Stack<Point>();
        if (board[x][y] == 'O') toTravel.add(new Point(x, y));
        while (!toTravel.isEmpty()) {
            Point point = toTravel.pop();
            if (visited.contains(point)) continue;
            x = point.x;
            y = point.y;
            board[x][y] = '#';
            visited.add(point);
            if (x - 1 >= 0 && board[x - 1][y] == 'O') toTravel.add(new Point(x - 1, y));
            if (x + 1 < board.length && board[x + 1][y] == 'O') toTravel.add(new Point(x + 1, y));
            if (y - 1 >= 0 && board[x][y - 1] == 'O') toTravel.add(new Point(x, y - 1));
            if (y + 1 < board[0].length && board[x][y + 1] == 'O') toTravel.add(new Point(x, y + 1));
        }
    }

    private void change(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            traverse(board, i, 0);
            traverse(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            traverse(board, 0, i);
            traverse(board, m - 1, i);
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point other = (Point) obj;
                return other.x == x && other.y == y;
            }
            return false;
        }
    }
}
