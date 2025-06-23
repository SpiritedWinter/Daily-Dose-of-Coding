package com.dailydose.binary_search;

public class SingleNonDuplicate {
    public static void main(String[] args){

    }
    public static singleNoonDuplicate(int[] nums){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==nums[mid+1] && mid%2==0){
                start=mid;
            }
            else if(nums[mid-1]==nums[mid] && (end-mid-1)%2==0){
                end=mid;
            }
        }
    }
}
