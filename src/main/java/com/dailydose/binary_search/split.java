package com.dailydose.binary_search;
import java.util.*;

public class split{
    public static void main(String[] args){

    }

    public static int splitArray(int[] nums,int k){
        int start=Arrays.stream(nums).max().getAsInt() ;
        int end=  Arrays.stream(nums).sum();

        while(start<end){
            int mid= start+(end-start)/2;
            if(isFeasable(nums ,mid,k)){
                end=mid;
            }
            else{
                start=mid;
            }
        }

        return start;
    }

    public static boolean isFeasable(int[] nums,int mid,int k){
        int parts=1;
        int sum=0;
        for(int num:nums){
            if(num+sum>mid){
                parts+=1;
                sum=num;
            }
            else{
                sum+=num;
            }
        }
        return parts<=k;
    }


}