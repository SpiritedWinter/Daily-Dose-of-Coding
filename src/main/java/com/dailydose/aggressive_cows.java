package com.dailydose;

import java.util.*;
public class aggressive_cows {
    public static void main(String[] args){
        System.out.println(aggresiveCows(new int[]{1,2,4,8,9},3));
    }
    public static int aggresiveCows(int[] stalls, int k){
        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];
        int sol=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isFeasable(stalls,k,mid)){
                sol=mid;
                start=mid+1;
            }

            else{
                end=mid-1;
            }
        }

        return sol;

    }

    public static boolean isFeasable(int[] position, int k,int target){
        int bhens=1;
        int currPos=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-currPos>=target){
                bhens+=1;
                currPos=position[i];
            }
            if(bhens>=k){
                return true;
            }
        }
        return false ;
    }

}
