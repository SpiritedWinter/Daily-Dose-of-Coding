package com.dailydose.binary_search;

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

}
