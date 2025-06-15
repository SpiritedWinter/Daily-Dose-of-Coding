package com.dailydose.recursion_and_backtracking;
import java.util.*;
public class RatMaze {
    public static void main(String[] args){
        int[][] maze= new int[][]{{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        System.out.println(ratInMaze(maze,0,0,"",new ArrayList<String>()));
    }
    private static ArrayList<String> ratInMaze(int[][] maze,int row, int col,String path, ArrayList<String> result){
        if(row==maze.length-1 && col==maze.length-1){
            result.add(path);
            return result;
        }
        if(row<0 || col<0 || row>=maze.length || col>=maze.length || maze[row][col]==0){
            return result;
        }
        maze[row][col]=0;
        ratInMaze(maze, row, col+1, path+"R", result);
        ratInMaze(maze, row, col-1, path+"L", result);
        ratInMaze(maze, row+1, col, path+"D", result);
        ratInMaze(maze, row-1, col, path+"U", result);
        maze[row][col]=1;

        return result;
    }
}
