package com.dailydose.binary_search;
import java.util.*;
public class FindSmallestdivisor {
    public static void main(String[] args){
        int[] nums=new int[]{44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }

    public static int smallestDivisor(int[] nums,int threshold){
        int start=1;
        int end=Arrays.stream(nums).max().getAsInt();
        while(start<end){
            int mid=start+(end-start)/2;
            if(isFeasible(nums,threshold,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return start;
    }
    private static boolean isFeasible(int nums[],int threshold,int minDivisor){
        int sumDivisor=0;
        for(int i=0;i<nums.length;i++){
            sumDivisor+=getCeil(nums[i], minDivisor);
            if(sumDivisor>threshold){
                return false;
            }
        }

        return true;
    }
    private static int getCeil(int divident,int divisor){
        return (divident+divisor-1)/divisor;
    }
}
