package com.dailydose.binary_search;

public class KthSmallestElementMatrix {
    // Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

    // Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    // You must find a solution with a memory complexity better than O(n2).
    public static void main(String[] args){
            int[][] matrix=new int[][]{{1,5,9},{10,12,13},{12,13,15}};
            System.out.println(kthSmallest(matrix, 8));
    }
    public static int kthSmallest(int[][] matrix ,int k){
        int n=matrix.length;
        int start=matrix[0][0];
        int end=matrix[n-1][n-1];
        int result=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isFeasable(matrix, mid, k)){
                result=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return result;
    }
    public static boolean isFeasable(int[][] matrix, int mid,int k){
        
        //how many elements are less than the the mid
        // current column and 

        int row=matrix.length-1;
        int col=0;
        int count=0;
        int n=matrix.length;
        while(row>=0 && col<matrix.length){
            if(matrix[row][col]<mid){
                count+=row+1;
                col++;
            }
            else{
                row--;
            }
        }

        return count<k;
    }
}
