Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution"

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100


Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution


import java.io.*;
import java.util.*;

class P1{
    
    static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    
    
    static boolean solver(int[][] board, int col, int n){
        if(col >= n){
            return true;
        }
        for (int i = 0; i < n; i++){ 
            if(isSafe(board, i , col, n)){
                board[i][col] = 1;
                if(solver(board, col + 1, n)){
                    return true;
                }
                else{
                    board[i][col] = 0;
                }
            }
        }
        return false;
    }
    
    static void placeQueens(int n) {
        int[][] board = new int[n][n];
        if (solver(board, 0, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("No Solution");
        }
    }
    
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        placeQueens(n);
    }
}
