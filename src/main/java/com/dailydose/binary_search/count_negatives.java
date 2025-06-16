package com.dailydose.binary_search;
import java.util.*;

public class count_negatives{
    public static void main(String[] args){
        int[] arr=new int[]{2,3,4,7,11};
        System.out.println(kthMissingNumber(arr,5));
    }

    public static int countNeg(int[][] grid){
        int count=0;
        // given that the array is sorted in non-increasing order,both the row wise and column wise
        // traversing the grid diagnally and finding if the diagnal elelment from the last is negative, if its not we're gonna break
        // for traversing diagonally
        for(int i=grid.length-1,j=grid[0].length-1;i>=0 && j>=0; i--,j--){
            //check each diagnal element if not negative then no need of traversing furthers
            if(grid[i][j]>=0){
                break;
            }
            // now do the main operation of finding the negatives
            //row wise traversal
            for(int row=i; row>=0; row--){
                if(grid[row][j]>=0) break;
                count++;
            }
            // column wise traversal
            for(int col=j-1; col>=0; col--){
                if(grid[i][col]>=0) break;
                count++;
            }
            
        }
        return count;
    }
    //binary search approach//// better
    private static int  countBN(int[][] matrix){
        int  i= matrix.length-1;
        int j=0;
        int count=0;
        while( i>=0 && j<matrix[0].length){
            if(matrix[i][j]<0){
                count+=(matrix[0].length - j);
                i--;
            }
            else{
                j++;
            }
        }
        return count;
    }

    // kth missing positive number
    public static int kthMissingNumber(int[] arr, int k){
        int count=0;
        for(int i=1;i<arr[arr.length-1];i++){
            if(!doesExists(arr,  i)){
                count+=1;
                if(count==k){
                    return i;
                }
            }
        }
        return-1;
    }

    public static boolean doesExists(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            if(target>arr[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}