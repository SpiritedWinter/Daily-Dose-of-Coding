package com.dailydose.binary_search;

import java.util.*;

public class moutain_array {
    public static void main(String[] args){

        int[] arr= new int[]{1,2,2,2,2,2,6};
        System.out.println(findLastOccur(arr,2));

    }
    public static int findPeak(int[] arr){
        int start=0;
        int end= arr.length-1;

        while(start<end){
            int mid= start+(end-start)/2;

            if( arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return arr[start];
    }
    public static int ceiling (int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid= start+(end-start)/2;
            if(arr[mid]==target){
                return arr[mid];
            }
            if(arr[mid]>target){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return arr[start];
    }
    public static int firstOccur(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                end=mid;
            }
            else if( nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return nums.length!=0 && nums[start]==target?start:-1;
    }

    public static int findLastOccur(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        int result=-1;
        while(start<=end){
            int mid=start+ (end-start)/2;
            if(arr[mid]==target){
                result=mid;
                start=mid+1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        return result;

    }


    public static void meadianSortedArrays(int[] nums1, int[] nums2){

        //[1,3,6]   [2,4,5]
        //[1,2,3,4,5,6];
        // length of arr1 + length of arr2/2;
        // (3+4)/2 => 3.5
        // 3.5 is the answer
        // i pointer for nums 1
        // j pointer for nums 2
        //

        // lets take an example of  [1,3,6,12,15] [2,5,9,20]
        //  in this example if we just place first four places correctly then we would get our mediam
        // its somewhat related to the length of two array
        // we take 

    }
}

