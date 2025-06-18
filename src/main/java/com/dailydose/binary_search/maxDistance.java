package com.dailydose.binary_search;

import java.util.Arrays;

public class maxDistance {
    public static void main(String[] args){

    }

    public  int maxDistance(int[] position, int k){
        Arrays.sort(position);
        int start=position[0];
        int end=position[position.length-1]- position[0];
        int result=0;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(isFeasable(position,k,mid)){
                result=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            
            }
        }

        return result;
    }

    private  boolean isFeasable(int[] position, int k, int mid){
        int balls=1;
        int currPos=position[0];
        for(int i=1; i<position.length;i++){
            if(position[i]-currPos>=mid){
                balls+=1;
                currPos=position[i];
            }
            if(balls>=k){
                return true;
            }
        }

        return false ;
    }

    
}
