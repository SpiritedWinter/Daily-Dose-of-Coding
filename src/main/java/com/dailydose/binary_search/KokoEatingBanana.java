package com.dailydose.binary_search;

import java.util.Arrays;

public class KokoEatingBanana {
    public static void main(String[] args){

    }

    public static int minEatingSpeed(int[] piles,int h){
        int start=Arrays.stream(piles).min().getAsInt();
        int end=Arrays.stream(piles).sum();

        while(start<end){
            int mid=start+(end-start)/2;
            if(isFeasible(piles,h,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return start;
    }

    private static boolean isFeasible(int[] piles, int h ,int minEatingSpeed){

        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(piles[i]+minEatingSpeed-1)/minEatingSpeed;
        }


        return hours<=h;

    }
}
