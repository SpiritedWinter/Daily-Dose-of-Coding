package com.dailydose.binary_search;
import java.util.*;
public class koko_eating_banana {
    public static void main(String args){

    }
    public static int minEatingSpeed(int[] piles, int h){
        int start=1;
        int end=Arrays.stream(piles).sum();

        while(start<end){

            int mid=start+(end-start)/2;
            if(isFeasible(piles, h, mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
            //// feasible check now
        }

        return start;
    }

    public static boolean isFeasible(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil(pile/k)
            if (hours > h) return false;
        }
        return true;
    }
    

    
    
    
}
