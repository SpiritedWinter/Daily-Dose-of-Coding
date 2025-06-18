package com.dailydose.binary_search;
import java.util.*;
public class painters_partition {
    public static void main(String[] args){

    }

    public static int paintersPartition(int[] nums, int k){
        int start=1;
        int end= Arrays.stream(nums).sum();
        while(start<end){
            int mid=start+(end-start)/2;
            if(isFeasable(nums,k,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return start;
    }

    private static boolean isFeasable(int[] nums, int k, int mid){
        int sum=0;
        int painters=1;
        for(int board:nums){
            if (sum+board>mid){
                painters+=1;
                sum=board;
            }
            else{
                sum+=board;
            }
        }

        return painters<=k;
    }
}
