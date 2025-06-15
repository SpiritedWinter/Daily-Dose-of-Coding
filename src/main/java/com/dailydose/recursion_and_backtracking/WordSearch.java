package com.dailydose.recursion_and_backtracking;
import java.util.*;
public class WordSearch {
    public static void main(String[] args){
            String word="HELLO";
            char[][] board=   new char[][]{{'X','X','X','X'},
                                           {'A','E','A','X'},
                                           {'L','L','L','O'},
                                            {'X','O','X','X'}};

            boolean doesExists = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (wordSearch(board, word, i, j, 0)) {
                        doesExists = true;
                        break;
                    }
                }
                if (doesExists) break;
            }
            System.out.println(doesExists);
            
    }

    public static boolean wordSearch(char[][] board,String word, int row,int col, int iStrIndex){
        if(row<0 || col<0 ||  row>=board.length || col>=board[0].length){
            return false;
        }
        if(iStrIndex==word.length()-1){
            if(board[row][col]==word.charAt(iStrIndex)){
                return true;
            }
            return false;
        }
        if(!(board[row][col]==word.charAt(iStrIndex)) || board[row][col]=='V'){
            return false;
        }
        char temp=board[row][col];
        board[row][col]='V';
        boolean istrue=  wordSearch(board, word, row, col+1, iStrIndex+1) ||
                         wordSearch(board, word, row, col-1, iStrIndex+1) ||
                         wordSearch(board, word, row+1, col, iStrIndex+1) ||
                         wordSearch(board, word, row-1, col, iStrIndex+1) ;
        
        board[row][col]=temp;
        return istrue;


    }
}
