package com.dailydose;

import java.util.*;
public class Maze {
    public static void main(String[] args){
        // int i=3;
        // int j=3;
        // String path = "";
        // ArrayList<String> result=new ArrayList<>();
        // System.out.println(Paths(i,j,path,result));
        System.out.println(solveNQueens(4));


    }
    private static int countPaths(int i,int j){
        if(i==1 || j==1){
            return 1;
        }
        return countPaths(i,j-1) +countPaths(i-1,j);
    }
    private static ArrayList<String> Paths(int i,int j,String path,ArrayList<String> result){
        if(i==1 && j==1){
            result.add(path);
            return result;
        }
        String newPath;
        if( i>1 && j>1){
            newPath=path+"D";       //Diagnal
            Paths(i-1,j-1,newPath,result);
        }
        if(j>1){
            newPath=path+"H";      // Horizontal
            Paths(i,j-1,newPath,result);
        }
        
        if(i>1){
            newPath=path+"V";       //Vertical
            Paths(i-1,j,newPath,result);
        }

        return result;

    }

    private static int pathsWithObstackles(int[][] paths, int i,int j){
        if(i==paths.length-1 && j ==paths[0].length-1){
            return 1;
        }
        if(paths[i][j]==1){
            return 0;
        }
        int count=0;
        if(j<paths[0].length-1){
            count=pathsWithObstackles(paths, i, j+1);
        }
        if(i<paths.length-1){
            count+=pathsWithObstackles(paths, i+1, j);
        }

        return count;
    }

    private static int unique(int i,int j, int[][] memo){
        if(i==memo.length-1 && j==memo[0].length-1){
            return 1;
        }
        if(i<=memo.length-1 && j<=memo[0].length-1){
            return memo[i][j];
        }
        int count=0;
        if(i<memo.length-1){
            count= unique(i+1,j,memo);
        }
        if(j<memo[0].length-1){
            count+=unique(i,j+1,memo);
        }
        memo[i][j]=count;

        return count;
    }

    private static ArrayList<String> stringPaths(int m,int n,String carryString,ArrayList<String> result ){

        if(m==2 && n==2){
            // path found so add it
            result.add(carryString);
            return result;
        }
        if(m>2|| n>2){
            // there will be no path
            return result;
        }
        stringPaths(m+1,n+1,carryString+"X",result);
        stringPaths(m, n+1, carryString+"R", result);
        stringPaths(m+1,n,carryString+"D",result);

        return result;
    }

    private static ArrayList<String> path360(int[][] maze, int i,int j, String carryString,ArrayList<String> result){

        if(i==maze.length-1 && j==maze[0].length-1){
             result.add(carryString);
             return result;
        }
        if(i<0 || j<0 || i>=maze.length || j>=maze[0].length || maze[i][j]==1){
            return result;
        }
        maze[i][j]=1;
        path360(maze,i+1,j,carryString+"D",result);
        path360(maze,i-1,j, carryString+"U",result);
        path360(maze,i,j+1, carryString+"R",result);
        path360(maze,i,j-1, carryString+"L",result);
        maze[i][j]=0;
        
        return result;
    }

    private static void nQueens(String[][] board,int row,ArrayList<ArrayList<String>> result){
        if (row>=board.length ){
            printBoard(board);
            return;
        }

        for(int col=0;col<board[0].length;col++){
            if(isValidPos(board,row,col)){
                 board[row][col]="Q";
                 nQueens(board, row+1, result);
                 board[row][col]=".";
            }
        }
        return;
    }
    private static boolean isValidPos(String[][] board, int row, int col) {
        //check upper-left Diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if ("Q".equals(board[i][j])) return false;
        }
        //look up
        for(int i=row; i>=0; i--){
            if("Q".equals(board[i][col]))  return false;
        }
        // check upper-right Diagonal
        for(int i=row,j=col; i>=0 && j<board[0].length;i--,j++){
            if("Q".equals(board[i][j]))  return false;
        }

        return true;
    }

    private static void printBoard(String[][] board) {
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    private static List<List<String>> solveNQueens(int n){
        ArrayList<String> input=new ArrayList<>();
        String x="";
        for(int i=0;i<n;i++){
            x+=".";
        }
        for(int i=0;i<n;i++){
            input.add(x);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        nQueensLeet(input, 0, result);
        return new ArrayList<>(result);

    }

    private static ArrayList<ArrayList<String>> nQueensLeet(ArrayList<String> board,int row, ArrayList<ArrayList<String>> result){
        if(row>=board.size()){
            result.add(new ArrayList<>(board));
            return result;
        }
        String currentRow=board.get(row);
        for(int col=0;col<currentRow.length();col++){
            if(isValidPos2(board,row,col)){
                board.set(row, currentRow.substring(0,col)+ "Q"+currentRow.substring(col+1));
                nQueensLeet(board,row+1,result);
                board.set(row,currentRow);
            }
        }
        return result;
    }

    private static boolean isValidPos2(ArrayList<String> board,int row, int col){
        for(int r=row,c=col;r>=0 && c>=0;r--,c--){
            String  curRow= board.get(r);
            if(curRow.charAt(c)=='Q'){
                return false;
            }
        }
        for (int r=row; r>=0; r--){
            String  curRow= board.get(r);
            if(curRow.charAt(col)=='Q'){
                return false;
            }
        }

        for (int r=row,c=col; r>=0 && c<board.get(0).length();r--,c++){
            String  curRow= board.get(r);
            if(curRow.charAt(c)=='Q'){
                return false;
            }
        }
        return true;
    }
}
